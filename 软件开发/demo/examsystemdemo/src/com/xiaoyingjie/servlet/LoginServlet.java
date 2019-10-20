package com.xiaoyingjie.servlet;
/** 
 * @author XiaoYingJie
 * @date 创建时间：2019年10月20日 下午6:37:03 
 * @version 1.0 
 **/

import java.io.IOException;
import java.sql.*;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import com.xiaoyingjie.dao.BaseDao;
 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginServlet() {
		super();
	}
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
 
		// 获取session
		HttpSession session = req.getSession();
		// 得到注册证号
		String id = req.getParameter("id");
		// 得到注册密码
		String pwd = req.getParameter("pwd");
		// 判断是否勾选自动登录
		String flag = req.getParameter("autologin");
		if ("y".equals(flag)) {
			// 创建两个Cookie对象
			Cookie nameCookie = new Cookie("username", id);
			// 设置Cookie的有效期为3天
			nameCookie.setMaxAge(60 * 60 * 24 * 3);
			Cookie pwdCookie = new Cookie("password", pwd);
			pwdCookie.setMaxAge(60 * 60 * 24 * 3);
			// 保存到Cookie
			resp.addCookie(nameCookie);
			resp.addCookie(pwdCookie);
			req.getRequestDispatcher("exam.jsp").forward(req, resp);
		}
		// 先查询数据库，看是否存在
		BaseDao dao = new BaseDao();
		Connection conn = dao.getConnection();
		String sql = " select*from tb_stu where stuId=? and pwd=? ";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				// 请求转发至考试页面 还未写
				String stuName = rst.getString("stuName");
				session.setAttribute("id", id);
				session.setAttribute("stuName", stuName);
				req.getRequestDispatcher("exam.jsp").forward(req, resp);
			} else {
				// 如果没有,那么重定向到错误界面，需要注册
				resp.sendRedirect("error.jsp");
			}
			dao.close(conn, pst, rst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}