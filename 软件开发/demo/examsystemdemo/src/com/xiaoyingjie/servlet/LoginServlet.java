package com.xiaoyingjie.servlet;
/** 
 * @author XiaoYingJie
 * @date ����ʱ�䣺2019��10��20�� ����6:37:03 
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
		// ���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
 
		// ��ȡsession
		HttpSession session = req.getSession();
		// �õ�ע��֤��
		String id = req.getParameter("id");
		// �õ�ע������
		String pwd = req.getParameter("pwd");
		// �ж��Ƿ�ѡ�Զ���¼
		String flag = req.getParameter("autologin");
		if ("y".equals(flag)) {
			// ��������Cookie����
			Cookie nameCookie = new Cookie("username", id);
			// ����Cookie����Ч��Ϊ3��
			nameCookie.setMaxAge(60 * 60 * 24 * 3);
			Cookie pwdCookie = new Cookie("password", pwd);
			pwdCookie.setMaxAge(60 * 60 * 24 * 3);
			// ���浽Cookie
			resp.addCookie(nameCookie);
			resp.addCookie(pwdCookie);
			req.getRequestDispatcher("exam.jsp").forward(req, resp);
		}
		// �Ȳ�ѯ���ݿ⣬���Ƿ����
		BaseDao dao = new BaseDao();
		Connection conn = dao.getConnection();
		String sql = " select*from tb_stu where stuId=? and pwd=? ";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				// ����ת��������ҳ�� ��δд
				String stuName = rst.getString("stuName");
				session.setAttribute("id", id);
				session.setAttribute("stuName", stuName);
				req.getRequestDispatcher("exam.jsp").forward(req, resp);
			} else {
				// ���û��,��ô�ض��򵽴�����棬��Ҫע��
				resp.sendRedirect("error.jsp");
			}
			dao.close(conn, pst, rst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}