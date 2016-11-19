package SSH.MEM.CONTROL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/IDCHECK.do")
public class IdCheck extends HttpServlet {
	private MEMDAO dao;
	private MEMDTO dto;
	JSONObject jObj;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String id = req.getParameter("id");
		dao = new MEMDAO();
		jObj = new JSONObject();
		
		try{
			jObj = dao.idcheck(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		resp.setContentType("text/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jObj);
		out.flush();
		out.close();
	}
}