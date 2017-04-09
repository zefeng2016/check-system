package com.zefeng.checksystem.mapper;

import java.util.List;

import com.zefeng.checksystem.bean.Clazz;



public interface ClazzMapper {
	/**
	 * 新增班级
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public int insertClazz(Clazz clazz) throws Exception;

	/**
	 * 修改班级
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateClazz(Clazz clazz, int id) throws Exception;

	/**
	 * 刪除班级
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteClazz(int id) throws Exception;

	/**
	 * 根据id查询班级信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Clazz selectClazzById(int id) throws Exception;

	/**
	 * 查询�?��的班级信�?	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Clazz> selectAllClazz() throws Exception;
}
