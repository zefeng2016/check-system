package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.bean.Post;
import com.zefeng.checksystem.bean.TdUser;
import com.zefeng.checksystem.bean.WeuiErrorInfo;
import com.zefeng.checksystem.common.PostJdbc;
import com.zefeng.checksystem.common.TdJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class PostTdSeRe extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PostTdSeRe() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String info = request.getParameter("sousuoxinxi");
		String name = "%" + info + "%";
		System.out.println(name);
		
		List<TdUser> user = searchTd(info);	
		//List<TdUser> user = TdJdbc.selectTdByTdName(name);
		//if (user != null) {
		if(user!=null&&user.size()>0){
			request.setCharacterEncoding("utf-8");
			request.setAttribute("tdusers", user);
			request.setAttribute("select", info);
			PrintConsole.Print("获取企业数据成功");
			request.getRequestDispatcher("/view/tdsere.jsp").forward(request, response);
		} else {
			String pagetitel = "系统错误";
			String errortitle = "数据库查询失败";
			String errorinfo = "系统错误，3秒后将自动返回！";
			String errornum = "102";
			WeuiErrorInfo error = new WeuiErrorInfo(pagetitel, errortitle, errorinfo, errornum);
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			PrintConsole.Print("获取企业数据失败");
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 *  初始化application
	 */
	public void initApplication() {
		ServletContext application = getServletContext();
		List<TdUser> user = TdJdbc.selectAllUser();
		application.setAttribute("tduser", user);
	}
	
	/**
	 * 按名模糊查找
	 * @param name
	 * @return
	 */
	public List<TdUser> searchTd(String name){
		List<TdUser> user =new ArrayList<TdUser>();
		if (getServletContext().getAttribute("tduser") == null) {
			initApplication();
		}
		List<TdUser> allusers = (List<TdUser>) getServletContext().getAttribute("tduser");
		for (TdUser tdUser : allusers) {
			if(tdUser.getTdname().contains(name)){
				user.add(tdUser);
			}
		}
		return user;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
