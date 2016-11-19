package SSH.JUMSU.CONTROL;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.JUMSUDAO;
import SSH.DTO.JUMSUDTO;

@WebServlet("/UPDATEJUMSU.do")
public class UpdateJumsuControl extends HttpServlet{
	private JUMSUDAO dao;
	private ArrayList<JUMSUDTO> list;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//idx=2000&Mem_name=±èÀ¯Á¤&Jumsu_score1=99&Jumsu_score2=98&Jumsu_score3=97
		String param1=req.getParameter("Mem_name");
		String param2=req.getParameter("idx");
		String param3=req.getParameter("Jumsu_score1");
		String param4=req.getParameter("Jumsu_score2");
		String param5=req.getParameter("Jumsu_score3");


		String mem_name=param1;
		int mem_num=Integer.parseInt(param2);
		int jumsu_score1=Integer.parseInt(param3);
		int jumsu_score2=Integer.parseInt(param4);
		int jumsu_score3=Integer.parseInt(param5);
		
		
		JUMSUDTO dto=new JUMSUDTO(mem_num, mem_name,jumsu_score1,jumsu_score2,jumsu_score3);
		int result=0;
		try {
			JUMSUDAO dao= new JUMSUDAO();
			result=dao.updateJumsu(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(result>0)resp.sendRedirect("./ALLJUMSUFIND.do");
//		else response.sendRedirect("guestEdit.naver?idx="+param1);
		else{
			req.setAttribute("bean", dto);
			req.setCharacterEncoding("UTF-8");
			req.getRequestDispatcher("content/jumsu_update.jsp").forward(req, resp);
		}
		
	}
		
	
}