package com.chinasoft.empSys.service.impl;

import java.sql.Date;

import com.chinasoft.empSys.dao.IRigisterDao;
import com.chinasoft.empSys.dao.impl.RigisterDao;
import com.chinasoft.empSys.service.IRigisterService;

public class RigisterService implements IRigisterService {
	IRigisterDao dao=new RigisterDao();

	

	@Override
	public int insertEmp(String name, String password, String gender, int age, Date hiredate, Double salary,
			String phone, String email) {
		
		 return dao.insertEmp(name,password,gender,age,hiredate,salary,phone,email);
	}

	

}
