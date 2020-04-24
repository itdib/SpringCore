package com.dib.controller;

import com.dib.dto.StudentDTO;
import com.dib.service.StudentOperationsService;
import com.dib.vo.StudentVO;

public class MainController {

	private StudentOperationsService service;

	public MainController(StudentOperationsService service) {
		System.out.println("MainController.MainController() 1 Param Constructor");
		this.service = service;
	}
	
	public String handleStudent(StudentVO vo)throws Exception{
		StudentDTO dto=null;
		String result=null;
		
		dto=new StudentDTO();
		
		
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		result=service.register(dto);
		
		return result;
	}
}
