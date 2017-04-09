package com.zefeng.checksystem.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zefeng.checksystem.bean.StuUser;
import com.zefeng.checksystem.mapper.StuUserMapper;
import com.zefeng.checksystem.tools.DBTools;

public class StuJdbc {
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	public static boolean insertUser(StuUser user) {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
		try {
			mapper.insertUser(user);
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
	 * 删除用户
	 * 
	 * @return
	 */
	public static boolean deleteUser(int id) {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
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
	 */
	public static void selectUserById(int id) {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
		try {
			StuUser user = mapper.selectUserById(id);
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 * @return
	 */
	public static List<StuUser> selectAllUser() {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
		try {
			List<StuUser> user = mapper.selectAllUser();
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
	 */
	public static void updateUser(StuUser user, int id) {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
		try {
			mapper.updateUser(user, id);
			System.out.println(user.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	/**
	 * 查询外校签到学生数量
	 * 
	 * @return
	 * @return
	 */
	public static int selectOurSchool() {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
		try {
			int cnt = mapper.selectOurSchool();
			session.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return 0;
	}

	/**
	 * 查询本校签到学生数量
	 * 
	 * @return
	 * @return
	 */
	public static int selectOtherSchool() {
		SqlSession session = DBTools.getSession();
		StuUserMapper mapper = session.getMapper(StuUserMapper.class);
		try {
			int cnt = mapper.selectOtherSchool();
			session.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return 0;
	}

}
