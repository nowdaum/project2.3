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
import SSH.DTO.BRDDTO;

@WebServlet("/UPDATEBRD.do")
public class UpdateBrdControl extends HttpServlet{
	private BANDAO dao;
	private ArrayList<BANDTO> list;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param1=req.getParameter("idx");
		String param2=req.getParameter("brd_title");
		String param3=req.getParameter("brd_content");
		
		
		int brd_num=Integer.parseInt(param1);
		String brd_title=param2;
		String brd_content=param3;
		BRDDTO dto=new BRDDTO(brd_num, brd_title, null, brd_content);
		int result=0;
		try {
			BRDDAO dao= new BRDDAO();
			result=dao.updateBrdinfo(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(result>0)resp.sendRedirect("ALLBRD.do");
//		else response.sendRedirect("guestEdit.naver?idx="+param1);
		else{
			req.setAttribute("bean", dto);
			req.getRequestDispatcher("content/brdedit.jsp").forward(req, resp);
		}
		
	}
		
	
}