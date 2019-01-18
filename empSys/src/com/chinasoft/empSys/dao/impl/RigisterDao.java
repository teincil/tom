package com.chinasoft.empSys.dao.impl;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.empSys.dao.IRigisterDao;
import com.chinasoft.empSys.utils.MyDBUtils;

public class RigisterDao implements IRigisterDao {
    


	@Override
	public int insertEmp(String name, String password, String gender, int age, Date hiredate, Double salary,
			String phone, String email) {
		QueryRunner run=new QueryRunner(MyDBUtils.getDataSource());
		try {
			return run.update("insert into emp values (?,?,?,?,?,?,?,?,?)", null,name,password,gender,age,hiredate,salary,phone,email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}



}
