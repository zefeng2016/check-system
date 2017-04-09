package com.zefeng.checksystem.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zefeng.checksystem.bean.Department;
import com.zefeng.checksystem.mapper.DepartmentMapper;
import com.zefeng.checksystem.tools.DBTools;

public class DepartmentJdbc {
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	public static boolean insertDepartment(Department department) {
		SqlSession session = DBTools.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		try {
			mapper.insertDepartment(department);
			System.out.println(department.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public static boolean deleteDepartment(int id) {
		SqlSession session = DBTools.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		try {
			mapper.deleteDepartment(id);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

	/**
	 * 根据id查询用户
	 * 
	 * @return
	 */
	public static Department selectDepartmentById(int id) {
		SqlSession session = DBTools.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		try {
			Department department = mapper.selectDepartmentById(id);
			System.out.println(department.toString());
			session.commit();
			return department;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 * @return
	 */
	public static List<Department> selectAllDepartments() {
		SqlSession session = DBTools.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		try {
			List<Department> department = mapper.selectAllDepartments();
			System.out.println(department.toString());
			session.commit();
			return department;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 根据ID修改用户
	 * 
	 * @return
	 */
	public static boolean updateDepartment(Department department, int id) {
		SqlSession session = DBTools.getSession();
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		try {
			mapper.updateDepartment(department, id);
			System.out.println(department.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;

	}

}
