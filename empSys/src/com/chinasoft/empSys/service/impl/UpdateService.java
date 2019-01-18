package com.chinasoft.empSys.service.impl;

import java.sql.Date;

import com.chinasoft.empSys.dao.IUpdateDao;
import com.chinasoft.empSys.dao.impl.UpdateDao;
import com.chinasoft.empSys.service.IUpdateService;

public class UpdateService implements IUpdateService {
	IUpdateDao dao=new UpdateDao();


	@Override
	public void UpdateEmp(int id,String name, String password, String gender, int age, Date hiredate, Double salary,
			String phone, String email) {
		dao.UpdateEmp(id,name,password,gender,age,hiredate,salary,phone,email);
	}

	

}
