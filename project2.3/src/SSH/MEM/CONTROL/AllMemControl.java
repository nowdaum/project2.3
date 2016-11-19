package SSH.MEM.CONTROL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/ALLMEM.do")
public class AllMemControl extends HttpServlet{
	private MEMDAO dao;
	private ArrayList<MEMDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doGet(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		List<MEMDTO> list = null;//게시판 목록 배열
		String param1=req.getParameter("p");
		
		int p=1;
		int row=15;
		int rowTot=1;
		if(param1!=null)p=Integer.parseInt(param1);//param1이 널이아니면 정수로 p에 값을 넣는다.

		try {
			MEMDAO dao = new MEMDAO();
			rowTot=dao.getTot();
			list = dao.allMeminfo(p,row);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pTot=(rowTot-1)/row+1;
		req.setAttribute("ptot", pTot);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("./content/mem.jsp").forward(req, resp);
	}
}