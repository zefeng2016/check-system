package com.zefeng.checksystem.common;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.zefeng.checksystem.bean.Clazz;
import com.zefeng.checksystem.bean.Department;

public class DepartClazzLink {
	private  List<Clazz> classes = ClazzJdbc.selectAllClazz();
	private  List<Department> departments = DepartmentJdbc.selectAllDepartments();
	public  String getDepartClazzLink(){
		try {
			for (Department department : departments) {
				List<Clazz> childs = new ArrayList<>();
				for (int i = 0; i < classes.size(); i++) {
					Clazz temp = classes.get(i);
					if (department.getId().equals(temp.getPid())) {
						childs.add(temp);
						classes.remove(temp);
						i--;
					}
				}
				department.setClasses(childs);
			}
			System.out.println("DepartClazzLink:"+JSONObject.toJSONString(departments)+"\n");
			return JSONObject.toJSONString(departments);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
}

