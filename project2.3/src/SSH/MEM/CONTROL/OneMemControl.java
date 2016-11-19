package SSH.MEM.CONTROL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/ONEMEM.do")
public class OneMemControl extends HttpServlet{
	MEMDTO dto;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param=req.getParameter("idx");
		int mem_num=0;
		if (!(param==null ||"".equals(param)))
		mem_num=Integer.parseInt(param);
		
		try {
			MEMDAO dao = new MEMDAO();
			dto =dao.oneMeminfo(mem_num);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("bean", dto);
		req.getRequestDispatcher("content/memberdetail.jsp").forward(req, resp);
	}
}