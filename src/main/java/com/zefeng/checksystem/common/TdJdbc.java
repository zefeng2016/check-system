package com.zefeng.checksystem.common;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zefeng.checksystem.bean.TdUser;
import com.zefeng.checksystem.mapper.TdUserMapper;
import com.zefeng.checksystem.tools.DBTools;

public class TdJdbc {
	/**
	 * 新增用户
	 * @return 
	 */
	public static int  insertUser(TdUser user) {
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			mapper.insertUser(user);
			System.out.println("新增企业信息:"+user.toString());
			session.commit();
			System.err.println("拿到新增企业ID"+user.getId());
			return user.getId() ;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return 0;
		
	}

	/**
	 * 删除用户
	 * @return 
	 */
	public static boolean deleteUser(int id) {
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			mapper.deleteUser(id);
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
	 * @return 
	 */
	public static TdUser selectUserById(int id) {
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			TdUser user = mapper.selectUserById(id);
			System.out.println(user.toString());
			session.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 查询所有的用户
	 * @return 
	 * @return 
	 */
	public static List<TdUser> selectAllUser() {
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			List<TdUser> user = mapper.selectAllUser();
			System.out.println(user.toString());
			session.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}
	
	/**
	 * 查询所有的用户
	 * @return 
	 * @return 
	 */
	public static List<TdUser> selectTdByTdName(String tdname){
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			List<TdUser> user = mapper.selectTdByTdName(tdname);
			System.out.println(user.toString());
			session.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}
	/**
	 * 根据ID修改用户
	 * @return 
	 */
	public static boolean updateUser(TdUser user) {
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			mapper.updateUser(user);
			System.out.println(user.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;

	}
	/**
	 * 根据数据总量
	 * @return 
	 */
	public static int selectTdCount() {
		SqlSession session = DBTools.getSession();
		TdUserMapper mapper = session.getMapper(TdUserMapper.class);
		try {
			
			int cnt = mapper.selectTdCount();
			session.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return 0;
	}

}
