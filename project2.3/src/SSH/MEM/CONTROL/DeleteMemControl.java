package SSH.MEM.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/DELETE.do")
public class DeleteMemControl extends HttpServlet{
	private MEMDAO dao;
	private ArrayList<MEMDTO> list;
	
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
			MEMDAO dao= new MEMDAO();
			result=dao.deleteMeminfo(mem_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0)resp.sendRedirect("ALLMEM.do");
	
	}
}