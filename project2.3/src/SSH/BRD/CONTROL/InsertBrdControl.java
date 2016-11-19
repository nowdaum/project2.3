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
import SSH.DB.DBconn;
import SSH.DTO.BANDTO;

@WebServlet("/INSERTBRD.do")
public class InsertBrdControl extends HttpServlet{
	private BANDAO dao;
	private ArrayList<BANDTO> list;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param2=req.getParameter("brd_title");
		String param3=req.getParameter("brd_content");
		//param값 검사
		//~~~
		
		String brd_title=param2;
		String brd_content=param3;
		int result=0;
		
		
		try {
			BRDDAO dao=new BRDDAO();
			result=dao.insertBrdinfo(brd_title,brd_content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("ALLBRD.do");//전체리스트
		else resp.sendRedirect("ADDBRD.do");//add폼
	}
	
}