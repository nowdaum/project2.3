package SSH.MEM.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/UPDATEMEM.do")
public class UpdateMemControl extends HttpServlet{
	private MEMDAO dao;
	private ArrayList<MEMDTO> list;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param1=req.getParameter("idx");
		String param2=req.getParameter("ban_num");
		String param3=req.getParameter("mem_name");
		String param4=req.getParameter("mem_id");
		String param5=req.getParameter("mem_pw");
		String param6=req.getParameter("mem_birth");
		String param7=req.getParameter("mem_grade");
		String param8=req.getParameter("mem_ph");
		
		
		int mem_num=Integer.parseInt(param1);
		int ban_num=Integer.parseInt(param2);
		String mem_name=param3;
		String mem_id=param4;
		String mem_pw=param5;
		int mem_birth=Integer.parseInt(param6);
		int mem_grade=Integer.parseInt(param7);
		String mem_ph=param8;
		MEMDTO dto=new MEMDTO(mem_num,ban_num,mem_name,mem_id,mem_pw,mem_birth,mem_grade,mem_ph);
		int result=0;
		try {
			MEMDAO dao= new MEMDAO();
			result=dao.updateMeminfo(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(result>0){
			HttpSession hs = req.getSession();
			
			hs.removeAttribute("login_name");
			hs.setAttribute("login_name", mem_name);
			
			if(hs.getAttribute("login_grade").equals("5")){
				
			}
			
			resp.sendRedirect("ALLMEM.do");
		}
		else{
			req.setAttribute("bean", dto);
			req.getRequestDispatcher("content/memedit.jsp").forward(req, resp);
		}
	}
}