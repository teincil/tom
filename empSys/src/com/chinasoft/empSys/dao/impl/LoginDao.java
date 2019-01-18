package com.chinasoft.empSys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chinasoft.empSys.dao.ILogindao;
import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.utils.MyDBUtils;

public class LoginDao implements ILogindao {

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		QueryRunner run=new QueryRunner(MyDBUtils.getDataSource());
		try {
			return run.query("select * from emp where name=? and password=?", new BeanHandler<Emp>(Emp.class),name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
