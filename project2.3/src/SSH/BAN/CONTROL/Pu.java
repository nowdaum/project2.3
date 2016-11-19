package SSH.BAN.CONTROL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BANDAO;
import SSH.DTO.BANDTO;

@WebServlet("/Pulist.do")
public class Pu extends HttpServlet {
	private List<BANDTO> list;
	private BANDTO dto;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		list = new ArrayList<BANDTO>();

		try {
			BANDAO dao = new BANDAO();
//			for (int ban_num = 1; ban_num <= 100; ban_num++) {
//				dto = new BANDTO();
//				dto = dao.SelectEducationInfo(ban_num);
//				list.add(dto);
			list = dao.SelectEducationInfo();
				
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// req.setAttribute("dto", dto

		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/content/publisher.jsp").forward(req, resp);
	}
}