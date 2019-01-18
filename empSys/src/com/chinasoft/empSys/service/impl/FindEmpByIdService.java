package com.chinasoft.empSys.service.impl;

import com.chinasoft.empSys.dao.IFindEmpByIdDao;
import com.chinasoft.empSys.dao.impl.FindEmpByIdDao;
import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.IFindEmpByIdService;

public class FindEmpByIdService implements IFindEmpByIdService {
	IFindEmpByIdDao dao=new FindEmpByIdDao();

	@Override
	public Emp findEmpById(int id) {
		return dao.findEmpById(id);
	}

	

}
