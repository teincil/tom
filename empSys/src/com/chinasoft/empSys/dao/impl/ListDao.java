package com.chinasoft.empSys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.empSys.dao.IListDao;
import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.utils.MyDBUtils;

public class ListDao implements IListDao {

	@Override
	public List<Emp> findAllEmp() {
		QueryRunner run=new QueryRunner(MyDBUtils.getDataSource());
		try {
			return run.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

}
