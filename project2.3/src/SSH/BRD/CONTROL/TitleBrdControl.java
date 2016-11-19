package SSH.BRD.CONTROL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BANDAO;
import SSH.DAO.BRDDAO;
import SSH.DTO.BANDTO;
import SSH.DTO.BRDDTO;
@WebServlet("/TITLEBRD.do")
public class TitleBrdControl extends HttpServlet{
	BRDDTO dto;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param=req.getParameter("idx2");
		int brd_num=0;
		if (!(param==null ||"".equals(param)))
		brd_num=Integer.parseInt(param);
		
		try {
			BRDDAO dao = new BRDDAO();
			dto =dao.titlefind(brd_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("bean", dto);
		req.getRequestDispatcher("content/brddetail.jsp").forward(req, resp);
	}
}