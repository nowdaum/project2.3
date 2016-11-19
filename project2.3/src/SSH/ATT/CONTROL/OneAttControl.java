package SSH.ATT.CONTROL;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.ATTDAO;
import SSH.DTO.ATTDTO;


@WebServlet("/ONEATT.do")
public class OneAttControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ATTDTO> list = null;//게시판 목록 배열
		String param1=req.getParameter("p");
		
		int p=1;
		int row=15;
		int rowTot=1;
		if(param1!=null)p=Integer.parseInt(param1);//param1이 널이아니면 정수로 p에 값을 넣는다.

		try {
			ATTDAO dao = new ATTDAO();
			rowTot=dao.getTot();
			list = dao.OneAttinfo(p,row);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pTot=(rowTot-1)/row+1;
		req.setAttribute("ptot", pTot);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("content/one.jsp").forward(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
