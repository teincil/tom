package com.chinasoft.empSys.service.impl;

import java.util.List;

import com.chinasoft.empSys.dao.IListDao;
import com.chinasoft.empSys.dao.impl.ListDao;
import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IListService;

public class Listservice implements IListService {
	IListDao dao=new ListDao();

	@Override
	public List<Emp> findAllEmp() {
		
		return dao.findAllEmp();
	}

	

}
