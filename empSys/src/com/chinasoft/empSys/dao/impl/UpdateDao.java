package com.chinasoft.empSys.dao.impl;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.empSys.dao.IUpdateDao;
import com.chinasoft.empSys.utils.MyDBUtils;

public class UpdateDao implements IUpdateDao {
     
	

	@Override
	public void UpdateEmp(int id,String name, String password, String gender, int age, Date hiredate, Double salary,
			String phone, String email) {
		QueryRunner run=new QueryRunner(MyDBUtils.getDataSource());
		try {
			 run.update("update Emp set name=?,password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=? where id=?",name,password,gender,age,hiredate,salary,phone,email,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
