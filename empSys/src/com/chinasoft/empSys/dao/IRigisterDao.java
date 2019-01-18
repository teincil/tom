package com.chinasoft.empSys.dao;

import java.sql.Date;

public interface IRigisterDao {

	int insertEmp(String name, String password, String gender, int age, Date hiredate, Double salary, String phone, String email);

}
