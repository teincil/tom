package com.chinasoft.empSys.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.chinasoft.empSys.dao.IDeleteEmpByIdDao;
import com.chinasoft.empSys.utils.MyDBUtils;

public class DeleteEmpByIdDao implements IDeleteEmpByIdDao {

	@Override
	public void DeleteEmpById(int id) {
         QueryRunner run =new QueryRunner(MyDBUtils.getDataSource());
         try {
			run.update("delete from emp where id=?", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
