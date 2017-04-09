package com.zefeng.checksystem.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zefeng.checksystem.bean.Clazz;
import com.zefeng.checksystem.mapper.ClazzMapper;
import com.zefeng.checksystem.tools.DBTools;

public class ClazzJdbc {
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	public static boolean insertClazz(Clazz clazz) {
		SqlSession session = DBTools.getSession();
		ClazzMapper mapper = session.getMapper(ClazzMapper.class);
		try {
			mapper.insertClazz(clazz);
			System.out.println(clazz.toString());
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
	public static boolean deleteClazz(int id) {
		SqlSession session = DBTools.getSession();
		ClazzMapper mapper = session.getMapper(ClazzMapper.class);
		try {
			mapper.deleteClazz(id);
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
	public static Clazz selectClazzById(int id) {
		SqlSession session = DBTools.getSession();
		ClazzMapper mapper = session.getMapper(ClazzMapper.class);
		try {
			Clazz Clazz = mapper.selectClazzById(id);
			System.out.println(Clazz.toString());
			session.commit();
			return Clazz;
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
	public static List<Clazz> selectAllClazz() {
		SqlSession session = DBTools.getSession();
		ClazzMapper mapper = session.getMapper(ClazzMapper.class);
		try {
			List<Clazz> clazz = mapper.selectAllClazz();
			System.out.println(clazz.toString());
			session.commit();
			return clazz;
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
	public static boolean updateClazz(Clazz clazz, int id) {
		SqlSession session = DBTools.getSession();
		ClazzMapper mapper = session.getMapper(ClazzMapper.class);
		try {
			mapper.updateClazz(clazz, id);
			System.out.println(clazz.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;

	}

}
