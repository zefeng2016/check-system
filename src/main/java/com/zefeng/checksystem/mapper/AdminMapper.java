package com.zefeng.checksystem.mapper;

import java.util.List;

import com.zefeng.checksystem.bean.Admin;

public interface AdminMapper {
	/**
	 * 新增用戶
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertAdmin(Admin user) throws Exception;

	/**
	 * 修改用戶
	 * 
	 * @param user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateAdmin(Admin user) throws Exception;

	/**
	 * 刪除用戶
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteAdmin(int id) throws Exception;

	/**
	 * 根据id查询管理员信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Admin selectAdminById(int id) throws Exception;
	/**
	 * 根据username查询管理员信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Admin selectAdminByUserName(String username) throws Exception;

	/**
	 * 查询所有的管理员信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Admin> selectAllAdmin() throws Exception;
	
}
