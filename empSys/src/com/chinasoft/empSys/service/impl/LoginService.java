package com.chinasoft.empSys.service.impl;

import com.chinasoft.empSys.dao.ILogindao;
import com.chinasoft.empSys.dao.impl.LoginDao;
import com.chinasoft.empSys.domain.Emp;
import com.chinasoft.empSys.service.ILoginService;
/*
 * 通过名字和密码查找用户的实现类
 * 
 */

public class LoginService implements ILoginService {
	ILogindao dao=new LoginDao();
	

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		
		return dao.findEmpByNameAndPassword(name,password);
	}

}
