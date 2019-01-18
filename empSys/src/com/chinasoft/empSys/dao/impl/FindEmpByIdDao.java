package com.chinasoft.empSys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.chinasoft.empSys.dao.IFindEmpByIdDao;
import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.utils.MyDBUtils;

public class FindEmpByIdDao implements IFindEmpByIdDao {

	@Override
	public Emp findEmpById(int id) {
		QueryRunner run=new QueryRunner(MyDBUtils.getDataSource());
		try {
			return run.query("select * from Emp where id=?",new BeanHandler<Emp>(Emp.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
