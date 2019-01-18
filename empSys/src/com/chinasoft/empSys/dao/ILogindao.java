package com.chinasoft.empSys.dao;

import com.chinasoft.empSys.domain.Emp;

public interface ILogindao {

	public Emp findEmpByNameAndPassword(String name, String password) ;
		
	

}
