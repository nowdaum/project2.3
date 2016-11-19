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

@WebServlet("/EDITJUMSU.do")
public class EditJumsuControl extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param=request.getParameter("idx");
		JUMSUDTO dto=null;
		int mem_num=Integer.parseInt(param);
		try {
			JUMSUDAO dao=new JUMSUDAO();
			dto=dao.detailJumsu(mem_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bean", dto);
		request.getRequestDispatcher("content/jumsu_update.jsp").forward(request, response);
	}
}

