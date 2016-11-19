package SSH.BAN.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import SSH.DAO.BANDAO;
import SSH.DAO.BRDDAO;
import SSH.DTO.BANDTO;

@WebServlet("/DELETEBAN.do")
public class DeleteBanControl extends HttpServlet{
	private BANDAO dao;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param=req.getParameter("num");
		int ban_num=Integer.parseInt(param);
		int result=0;
		try {
			BANDAO dao= new BANDAO();
			result=dao.deleteBaninfo(ban_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("list.do");
		else resp.sendRedirect("DETAILBAN.do?idx="+ban_num);
	
	}
}