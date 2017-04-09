package com.zefeng.checksystem.mapper;

import java.util.List;

import com.zefeng.checksystem.bean.Department;

public interface DepartmentMapper {
	/**
	 * 新增班级
	 * 
	 * @param Department
	 * @return
	 * @throws Exception
	 */
	public int insertDepartment(Department department) throws Exception;

	/**
	 * 修改班级
	 * 
	 * @param Department
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateDepartment(Department department, int id) throws Exception;

	/**
	 * 刪除班级
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteDepartment(int id) throws Exception;

	/**
	 * 根据id查询班级信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Department selectDepartmentById(int id) throws Exception;

	/**
	 * 查询�?��的班级信�?	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Department> selectAllDepartments() throws Exception;
}
