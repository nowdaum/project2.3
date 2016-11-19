package SSH.BRD.CONTROL;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import SSH.DB.DBconn;
import SSH.DAO.BRDDAO;
import SSH.DTO.BRDDTO;

@WebServlet("/ALLBRD.do")
public class AllBrdControl extends HttpServlet{
	private ArrayList<BRDDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<BRDDTO> list = null;//게시판 목록 배열
		String param1=req.getParameter("p");
		
		int p=1;
		int row=10;
		int rowTot=1;
		if(param1!=null)p=Integer.parseInt(param1);//param1이 널이아니면 정수로 p에 값을 넣는다.

		try {
			BRDDAO dao = new BRDDAO();
			rowTot=dao.getTot();
			list = dao.allBrdinfo(p,row);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pTot=(rowTot-1)/row+1;
		req.setAttribute("ptot", pTot);
		req.setAttribute("list", list);
		req.getRequestDispatcher("content/brd.jsp").forward(req, resp);
	}
	
}
