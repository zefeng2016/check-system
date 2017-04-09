package com.zefeng.checksystem.mapper;

import java.util.List;

import com.zefeng.checksystem.bean.TdUser;

public interface TdUserMapper {
	/**
	 * 新增用戶
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(TdUser user) throws Exception;

	/**
	 * 修改用戶
	 * 
	 * @param user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateUser(TdUser user) throws Exception;

	/**
	 * 刪除用戶
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(int id) throws Exception;

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TdUser selectUserById(int id) throws Exception;

	/**
	 * 查询所有的用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TdUser> selectAllUser() throws Exception;

	/**
	 * 根据企业名称查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TdUser> selectTdByTdName(String tdname) throws Exception;

	/**
	 * 查询列表总数据条数
	 * 
	 * @return
	 * @throws Exception
	 */
	public int selectTdCount() throws Exception;
}
