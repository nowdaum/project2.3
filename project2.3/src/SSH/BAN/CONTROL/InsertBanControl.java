package SSH.BAN.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BANDAO;
import SSH.DTO.BANDTO;

@WebServlet("/INSERTBAN.do")
public class InsertBanControl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String param1 = req.getParameter("ban_name");
		String param2 = req.getParameter("ban_inone");
		String param3 = req.getParameter("ban_period");
		String param4 = req.getParameter("ban_teacher");
		
		String ban_name=param1;
		int ban_inone=Integer.parseInt(param2);
		String ban_period=param3;
		String ban_teacher=param4;
		int result=0;
		
//		String driver=getServletContext().getInitParameter("driver");
//		String url=getServletContext().getInitParameter("url");
//		String user=getServletContext().getInitParameter("user");
//		String pw=getServletContext().getInitParameter("password");
		System.out.println(ban_name);
		System.out.println(ban_inone);
		System.out.println(ban_period);
		System.out.println(ban_teacher);
		
		try {
			BANDAO dao;
			dao = new BANDAO();
			result=dao.insertBaninfo(ban_name,ban_inone,ban_period,ban_teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("./list.do");
		else resp.sendRedirect("../content/pro_insert.jsp");
	}
}