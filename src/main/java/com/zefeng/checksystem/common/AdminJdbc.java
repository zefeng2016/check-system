package com.zefeng.checksystem.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zefeng.checksystem.bean.Admin;
import com.zefeng.checksystem.mapper.AdminMapper;
import com.zefeng.checksystem.tools.DBTools;

public class AdminJdbc {
	/**
	 * 新增管理员
	 * @return 
	 */
	public static int  insertAdmin(Admin admin) {
		SqlSession session = DBTools.getSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		try {
			mapper.insertAdmin(admin);
			System.out.println("新增管理员信息:"+admin.toString());
			session.commit();
			System.err.println("拿到新增管理员ID"+admin.getId());
			return admin.getId() ;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return 0;
		
	}

	/**
	 * 删除管理员
	 * @return 
	 */
	public static boolean deleteAdmin(int id) {
		SqlSession session = DBTools.getSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		try {
			mapper.deleteAdmin(id);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

	/**
	 * 根据id查询管理员
	 * @return 
	 */
	public static Admin selectAdminById(int id) {
		SqlSession session = DBTools.getSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		try {
			Admin admin = mapper.selectAdminById(id);
			System.out.println(admin.toString());
			session.commit();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}
	/**
	 * 根据username查询管理员
	 * @return 
	 */
	public static Admin selectAdminByUserName(String username) {
		SqlSession session = DBTools.getSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		try {
			Admin admin = mapper.selectAdminByUserName(username);
			System.out.println(admin.toString());
			session.commit();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 查询所有的管理员
	 * @return 
	 * @return 
	 */
	public static List<Admin> selectAllAdmin() {
		SqlSession session = DBTools.getSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		try {
			List<Admin> admin = mapper.selectAllAdmin();
			System.out.println(admin.toString());
			session.commit();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}
	/**
	 * 根据ID修改管理员
	 * @return 
	 */
	public static boolean updateAdmin(Admin admin) {
		SqlSession session = DBTools.getSession();
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		try {
			mapper.updateAdmin(admin);
			System.out.println(admin.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;

	}
	
}
