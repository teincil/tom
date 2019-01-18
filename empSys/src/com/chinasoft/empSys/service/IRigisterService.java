package com.chinasoft.empSys.service;

import java.sql.Date;

public interface IRigisterService {

	int insertEmp(String name, String password, String gender, int age, Date hiredate, Double salary, String phone, String email);

}
