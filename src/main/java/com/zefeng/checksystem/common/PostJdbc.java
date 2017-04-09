package com.zefeng.checksystem.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zefeng.checksystem.bean.Post;
import com.zefeng.checksystem.mapper.PostMapper;
import com.zefeng.checksystem.tools.DBTools;

public class PostJdbc {
	/**
	 * 新增岗位
	 * 
	 * @return
	 */
	public static boolean insertPost(Post post) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			mapper.insertPost(post);
			System.out.println(post.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

	/**
	 * 删除岗位
	 * 
	 * @return
	 */
	public static boolean deletePost(int id) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			mapper.deletePost(id);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

	/**
	 * 删除岗位
	 * 
	 * @return
	 */
	public static boolean deletePostByTdId(int tdid) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			mapper.deletePostByTdId(tdid);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

	/**
	 * 根据id查询岗位
	 * 
	 * @return
	 */
	public static Post selectPostById(int id) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			Post post = mapper.selectPostById(id);
			System.out.println(post.toString());
			session.commit();
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 根据tdid查询岗位
	 * 
	 * @return
	 */
	public static List<Post> selectPostByTdId(int tdid) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			List<Post> post = mapper.selectPostByTdId(tdid);
			System.out.println(post.toString());
			session.commit();
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 查询所有的岗位
	 * 
	 * @return
	 * @return
	 */
	public static List<Post> selectAllPost() {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			List<Post> post = mapper.selectAllPost();
			System.out.println(post.toString());
			session.commit();
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 查询所有的岗位
	 * 
	 * @return
	 * @return
	 */
	public static List<Post> selectPostByPostName(String postname) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			List<Post> post = mapper.selectPostByPostName(postname);
			System.out.println(post.toString());
			session.commit();
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}

	/**
	 * 根据ID修改岗位
	 * 
	 * @return
	 */
	public static boolean updatePost(Post post) {
		SqlSession session = DBTools.getSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		try {
			mapper.updatePost(post);
			System.out.println(post.toString());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;

	}

}
