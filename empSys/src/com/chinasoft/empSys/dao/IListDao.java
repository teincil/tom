package com.chinasoft.empSys.dao;

import java.util.List;

import com.chinasoft.empSys.domain.Emp;

public interface IListDao {

	List<Emp> findAllEmp();
	

}
