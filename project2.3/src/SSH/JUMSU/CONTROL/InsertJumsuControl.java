package SSH.JUMSU.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BRDDAO;
import SSH.DAO.JUMSUDAO;
import SSH.DTO.JUMSUDTO;

@WebServlet("/INSERTJUMSU.do")
public class InsertJumsuControl extends HttpServlet{
	private JUMSUDAO dao;
	private ArrayList<JUMSUDTO> list;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String param3=req.getParameter("mem_num");
		String param4=req.getParameter("mem_name");
		String param5=req.getParameter("jumsu_score1");
		String param6=req.getParameter("jumsu_score2");
		String param7=req.getParameter("jumsu_score3");
		//param값 검사
		//~~~
		
		int mem_num=Integer.parseInt(param3);
		String mem_name=param4;
		int jumsu_score1=Integer.parseInt(param5);
		int jumsu_score2=Integer.parseInt(param6);
		int jumsu_score3=Integer.parseInt(param7);
		int result=0;
		
		
		try {
			JUMSUDAO dao=new JUMSUDAO();
			result=dao.insertJumsu(mem_num,mem_name,jumsu_score1,jumsu_score2,jumsu_score3);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("ALLJUMSUFIND.do");//전체리스트
		else resp.sendRedirect("ADDJUMSU.do");//add폼
	}
	
}