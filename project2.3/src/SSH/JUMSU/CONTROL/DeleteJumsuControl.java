package SSH.JUMSU.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BANDAO;
import SSH.DAO.BRDDAO;
import SSH.DAO.JUMSUDAO;
import SSH.DTO.BANDTO;
import SSH.DTO.JUMSUDTO;

@WebServlet("/DELETEJUMSU.do")
public class DeleteJumsuControl extends HttpServlet{
	private JUMSUDAO dao;
	private ArrayList<JUMSUDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param=req.getParameter("idx");
		int mem_num=Integer.parseInt(param);
		int result=0;
		try {
			JUMSUDAO dao= new JUMSUDAO();
			result=dao.deleteJumsu(mem_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("ALLJUMSUFIND.do");
		else resp.sendRedirect("DETAILJUMSU.do?idx="+mem_num);
	
	}
}