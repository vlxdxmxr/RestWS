package com.web.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.rest.model.Instruction;

@Repository
public class InstructionsDaoImpl implements InstructionsDao {
	
	private final static String SELECT_INST_SQL = "SELECT * FROM instructions LIMIT ? OFFSET ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Instruction> getInstructions(final Integer limit, final Integer offset) {
		
		List<Instruction> instructions = new ArrayList<Instruction>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_INST_SQL, limit, offset);
		
		for(Map<String, Object> row : rows) {
			Instruction instruction = new Instruction();
			List<String> params = new ArrayList<String>();
			
			instruction.setId((Long)row.get("id"));
			instruction.setCommand((String)row.get("command"));
			
			for (String param : ((String)row.get("parameters")).split(",")) {
				params.add(param);
			}
			
			instruction.setParameters(params);
			
			instructions.add(instruction);
		}
		
		return instructions;
		
	}

}
