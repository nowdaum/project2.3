package SSH.JUMSU.CONTROL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import SSH.DAO.JUMSUDAO;
import SSH.DTO.JUMSUDTO;

@WebServlet("/DETAILJUMSU.do")
public class DetailJumsuControl extends HttpServlet{
	JUMSUDTO dto;
	//private JUMSUDTO dto;
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
			JUMSUDAO dao = new JUMSUDAO();
			dto =dao.detailJumsu(mem_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("bean", dto);
		req.getRequestDispatcher("content/jumsu_detail.jsp").forward(req, resp);
	}
}