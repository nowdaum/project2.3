package SSH.MEM.CONTROL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import SSH.DAO.MEMDAO;
import SSH.DTO.MEMDTO;

@WebServlet("/PASSFIND.do")
public class PASSFindControl extends HttpServlet{
	private MEMDAO dao;
	private JSONObject jo;
	private JSONObject jo2;
	private JSONArray ja;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		dao = new MEMDAO();
		jo = new JSONObject();
		jo2 = new JSONObject();
		ja = new JSONArray();
		
		String name = req.getParameter("name");
		int birth = Integer.parseInt(req.getParameter("birth"));
		String id = req.getParameter("pw");
		String pw = null;
		
		try{
			pw = dao.passfind(name, birth, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		jo.put("mem_pw", pw);
		ja.add(jo);
		jo2.put("pw", ja);
		
		resp.setContentType("text/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jo2);
		out.flush();
		out.close();
	}
}