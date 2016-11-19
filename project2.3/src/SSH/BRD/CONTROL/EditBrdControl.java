package SSH.BRD.CONTROL;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BRDDAO;
import SSH.DTO.BRDDTO;


@WebServlet("/EDITBRD.do")
public class EditBrdControl extends HttpServlet {
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("idx");
		BRDDTO dto=null;
		int brd_num=Integer.parseInt(param);
		try {
				BRDDAO dao= new BRDDAO();
				dto=dao.titlefind(brd_num); //상세보기 메소드/ brd_num만 인자로받아 select문을 날려 해당 정보 받아온다.
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("bean", dto);
			req.getRequestDispatcher("content/brdedit.jsp").forward(req, resp);
	}
}
