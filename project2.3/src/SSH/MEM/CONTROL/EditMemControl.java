package SSH.MEM.CONTROL;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BRDDAO;
import SSH.DAO.MEMDAO;
import SSH.DTO.BRDDTO;
import SSH.DTO.MEMDTO;


@WebServlet("/EDITMEM.do")
public class EditMemControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		MEMDTO dto=null;
		int mem_num=Integer.parseInt(param);
		try {
				MEMDAO dao= new MEMDAO();
				dto=dao.oneMeminfo(mem_num); //상세보기 메소드/ brd_num만 인자로받아 select문을 날려 해당 정보 받아온다.
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("bean", dto);
			req.getRequestDispatcher("content/memedit.jsp").forward(req, resp);
	
	}
}