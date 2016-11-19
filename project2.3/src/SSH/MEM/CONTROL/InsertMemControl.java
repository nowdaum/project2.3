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

@WebServlet("/INSERTMEM.do")
public class InsertMemControl extends HttpServlet{
	private MEMDAO dao;
	private ArrayList<MEMDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = null;
		String id = null;
		String pass = null;
		int birth = 0;
		String year = null;
		String month = null;
		String day = null;
		String ph = null;
		int cal = 0;
		name = req.getParameter("name");
		id = req.getParameter("id");
		pass = req.getParameter("pass");
		
		year = req.getParameter("year");
		month =  req.getParameter("month");
		day = req.getParameter("day");
		
		if(Integer.parseInt(month) < 10){
			month = "0" + req.getParameter("month");
		}
		
		if(Integer.parseInt(day) < 10){
			day = "0" + req.getParameter("day");
		}
		
		birth = Integer.parseInt((year + month + day));
		ph = req.getParameter("ph1") + req.getParameter("ph2") + req.getParameter("ph3");
		
		dao = new MEMDAO();
		
		try {
			cal = dao.insertMeminfo(name, id, pass, ph, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cal > 0){
			resp.sendRedirect("/project2/content/main.jsp");
		}else {
			resp.sendRedirect("/project2/content/main.jsp");
		}
		
	}
}