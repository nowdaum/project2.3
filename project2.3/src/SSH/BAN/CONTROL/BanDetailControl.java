package SSH.BAN.CONTROL;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.BANDAO;
import SSH.DTO.BANDTO;

@WebServlet("/DETAILBAN.do")
public class BanDetailControl extends HttpServlet {
	BANDTO dto;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("idx");
		int ban_num = 0;
		if (!(param == null || "".equals(param)))
			ban_num = Integer.parseInt(param);

		try {
			BANDAO dao = new BANDAO();
			dto = dao.selectOne(ban_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", dto);
		request.getRequestDispatcher("content/bandetail.jsp").forward(
				request, response);
	}

}
