package SSH.BAN.CONTROL;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BANDAO;
import SSH.DAO.BRDDAO;
import SSH.DTO.BANDTO;
import SSH.DTO.BRDDTO;


@WebServlet("/EDITBAN.do")
public class EditBanControl extends HttpServlet {
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param=req.getParameter("num");
		BANDTO dto=null;
		int ban_num=Integer.parseInt(param);
		try {
				BANDAO dao= new BANDAO();
				dto=dao.selectOne(ban_num); //�󼼺��� �޼ҵ�/ brd_num�� ���ڷι޾� select���� ���� �ش� ���� �޾ƿ´�.
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("content/pro_update.jsp").forward(req, resp);
	}
}
