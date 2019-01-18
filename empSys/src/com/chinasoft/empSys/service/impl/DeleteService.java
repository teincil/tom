package com.chinasoft.empSys.service.impl;

import com.chinasoft.empSys.dao.IDeleteEmpByIdDao;
import com.chinasoft.empSys.dao.impl.DeleteEmpByIdDao;
import com.chinasoft.empSys.service.IDeleteService;

public class DeleteService implements IDeleteService {
	IDeleteEmpByIdDao delete=new DeleteEmpByIdDao();
	

	@Override
	public void DeleteEmpById(int id) {
		// TODO Auto-generated method stub
delete.DeleteEmpById(id);
	}

}
