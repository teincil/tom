package com.chinasoft.empSys.service;

import com.chinasoft.empSys.domain.Emp;

public interface ILoginService {
	/*
	 * 通过名字和密码查找用户的接口
	 */

	Emp findEmpByNameAndPassword(String name, String password);

}
