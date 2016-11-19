package SSH.MEM.CONTROL;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/ONEEDIT.do")
public class OneEdit extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		MEMDTO dto=null;
		int mem_num=Integer.parseInt(param);
		try {
				MEMDAO dao= new MEMDAO();
				dto=dao.oneMem(mem_num); //�󼼺��� �޼ҵ�/ brd_num�� ���ڷι޾� select���� ���� �ش� ���� �޾ƿ´�.
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("bean", dto);
			req.getRequestDispatcher("content/onememedit.jsp").forward(req, resp);
	
	}
}