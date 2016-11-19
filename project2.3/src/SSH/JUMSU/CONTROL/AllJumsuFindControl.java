package SSH.JUMSU.CONTROL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BRDDAO;
import SSH.DAO.JUMSUDAO;
import SSH.DTO.BRDDTO;
import SSH.DTO.JUMSUDTO;

@WebServlet("/ALLJUMSUFIND.do")
public class AllJumsuFindControl extends HttpServlet{
	private JUMSUDAO dao;
	private ArrayList<JUMSUDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		doGet(req, resp);
	}
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<JUMSUDTO> list = null;
		
		int ban_num=10000;
		
		try {
			JUMSUDAO dao = new JUMSUDAO();
			list = dao.allJumsufind(ban_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("./content/jumsu.jsp").forward(req, resp);
	}
	
}
