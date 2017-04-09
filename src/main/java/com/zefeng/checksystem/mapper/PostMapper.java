package com.zefeng.checksystem.mapper;

import java.util.List;

import com.zefeng.checksystem.bean.Post;

public interface PostMapper {
	/**
	 * 新增岗位
	 * 
	 * @param Post
	 * @return
	 * @throws Exception
	 */
	public int insertPost(Post post) throws Exception;

	/**
	 * 修改岗位
	 * 
	 * @param Post
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updatePost(Post post) throws Exception;

	/**
	 * 刪除岗位
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deletePost(int id) throws Exception;

	/**
	 * 刪除岗位
	 * 
	 * @param tdid
	 * @return
	 * @throws Exception
	 */
	public int deletePostByTdId(int tdid) throws Exception;

	/**
	 * 根据id查询岗位信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Post selectPostById(int id) throws Exception;

	/**
	 * 根据id查询岗位信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Post> selectPostByTdId(int tdid) throws Exception;

	/**
	 * 根据名称查询岗位信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Post> selectPostByPostName(String postname) throws Exception;

	/**
	 * 查询�?��的岗位信�?	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Post> selectAllPost() throws Exception;
}
