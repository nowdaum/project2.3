package SSH.BRD.CONTROL;

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

@WebServlet("/DELETEBRD.do")
public class DeleteBrdControl extends HttpServlet{
	private BANDAO dao;
	private ArrayList<BANDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param=req.getParameter("idx");
		int brd_num=Integer.parseInt(param);
		int result=0;
		try {
			BRDDAO dao= new BRDDAO();
			result=dao.deleteBrdinfo(brd_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("ALLBRD.do");
		else resp.sendRedirect("TITLEBRD.do?idx="+brd_num);
	
	}
}