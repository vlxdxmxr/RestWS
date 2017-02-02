package com.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.rest.dao.InstructionsDao;
import com.web.rest.model.Instruction;

@RestController
public class MainController {
	
	@Autowired
	InstructionsDao instructionDao;
	
	@RequestMapping("/instruction")
	public List<Instruction> instruction(@RequestParam(name = "limit", value="limit") Integer limit,
			@RequestParam(name = "offset", value="offset") Integer offset) {
		return instructionDao.getInstructions(limit, offset);
	}
}
