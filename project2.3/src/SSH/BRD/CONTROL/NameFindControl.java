package SSH.BRD.CONTROL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import SSH.DAO.BRDDAO;

@WebServlet("/NAMEFIND.do")
public class NameFindControl extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
//		List<BRDDTO> list = null;
//		String mem_name = req.getParameter("mem_name");
//		list = dao.namefind(mem_name);
	
	
	String mem_name = req.getParameter("mem_name");
	
	JSONArray jsonArray = new JSONArray();
	
	BRDDAO dao = new BRDDAO();
	jsonArray = dao.namefind(mem_name);

	
	JSONObject jObj = new JSONObject();
	jObj.put("mlist", jsonArray);
	
	resp.setContentType("text/json");
	resp.setCharacterEncoding("UTF-8");
	
	
	PrintWriter out = resp.getWriter();
	out.print(jObj);
	out.flush();
	out.close();

	}
}