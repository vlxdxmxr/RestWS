package com.web.rest.dao;

import java.util.List;

import com.web.rest.model.Instruction;

public interface InstructionsDao {
	public List<Instruction> getInstructions(Integer limit, Integer Offset);
}
