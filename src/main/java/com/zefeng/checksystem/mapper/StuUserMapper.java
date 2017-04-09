package com.zefeng.checksystem.mapper;

import java.util.List;

import com.zefeng.checksystem.bean.StuUser;

public interface StuUserMapper {
	/**
	 * 新增用戶
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(StuUser user) throws Exception;

	/**
	 * 修改用戶
	 * 
	 * @param user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateUser(StuUser user, int id) throws Exception;

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
	public StuUser selectUserById(int id) throws Exception;

	/**
	 * 查询�?��的用户信�?	 * 
	 * @return
	 * @throws Exception
	 */
	public List<StuUser> selectAllUser() throws Exception;

	/**
	 * 统计�?��的外校学校签到数�?	 * 
	 * @return
	 * @throws Exception
	 */
	public int selectOtherSchool() throws Exception;

	/**
	 * 统计�?��本校签到学生数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public int selectOurSchool() throws Exception;

}
