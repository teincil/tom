package com.chinasoft.empSys.service;
/*
 * 修改学生信息
 */

import java.sql.Date;

public interface IUpdateService {

	void UpdateEmp(int id, String name, String password, String gender, int age, Date hiredate, Double salary, String phone, String email);

}
