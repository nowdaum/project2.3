package SSH.FINDHEWON.CONTROL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.FINDHEWONDAO;
import SSH.DTO.FINDHEWONDTO;

@WebServlet("/ALLFINDHEWON.do")
public class AllFindHewonControl extends HttpServlet{
	private FINDHEWONDAO dao;
	private ArrayList<FINDHEWONDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<FINDHEWONDTO> list = null;//게시판 목록 배열
		String param1=req.getParameter("p");
		
		int p=1;
		int row=15;
		int rowTot=1;
		if(param1!=null)p=Integer.parseInt(param1);//param1이 널이아니면 정수로 p에 값을 넣는다.

		try {
			FINDHEWONDAO dao = new FINDHEWONDAO();
			rowTot=dao.getTot();
			list = dao.allFindhewoninfo(p,row);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pTot=(rowTot-1)/row+1;
		req.setAttribute("ptot", pTot);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("./content/sale.jsp").forward(req, resp);
	}
	
}