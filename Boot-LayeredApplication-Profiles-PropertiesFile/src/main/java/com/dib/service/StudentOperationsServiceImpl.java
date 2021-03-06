package com.dib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dib.bo.StudentBO;
import com.dib.dao.StudentDAO;
import com.dib.dto.StudentDTO;

@Service("studService")
public class StudentOperationsServiceImpl implements StudentOperationsService {
	
	@Autowired
	private StudentDAO dao;

	@Override
	public String register(StudentDTO dto) throws Exception {
	
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		int count=0;
		
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		
		if(dto.getM1()<35||dto.getM2()<35||dto.getM3()<35)
			result="fail";
		else
			result="pass";
		
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		count=dao.insert(bo);
		
		if(count==0)
			return "Student Registration Failed";
		else
			return "Student Registration Succeded and Total="+total+" Average="+avg+" Result="+result;
	}

}
