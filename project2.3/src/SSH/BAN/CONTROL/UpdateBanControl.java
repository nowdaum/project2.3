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

@WebServlet("/UPDATEBAN.do")
public class UpdateBanControl extends HttpServlet{
	private BANDAO dao;
	private ArrayList<BANDTO> list;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param1=req.getParameter("num");
		String param2=req.getParameter("ban_name");
		String param3=req.getParameter("ban_inone");
		String param4=req.getParameter("ban_period");
		String param5=req.getParameter("ban_teacher");
		
		
		int ban_num=Integer.parseInt(param1);
		String ban_name=param2;
		int ban_inone=Integer.parseInt(param3);
		String ban_period=param4;
		String ban_teacher=param5;
		BANDTO dto=new BANDTO(ban_num, ban_name, ban_inone, ban_period, ban_teacher);
		int result=0;
		try {
			BANDAO dao= new BANDAO();
			result=dao.updateBaninfo(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(result>0)resp.sendRedirect("list.do");
		else{
			req.setAttribute("dto", dto);
			req.setCharacterEncoding("UTF-8");
			req.getRequestDispatcher("DETAILBAN.do").forward(req, resp);
		}
	}
}