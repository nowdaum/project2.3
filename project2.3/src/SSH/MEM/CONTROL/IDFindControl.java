package SSH.MEM.CONTROL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import SSH.DAO.MEMDAO;

@WebServlet("/IDFIND.do")
public class IDFindControl extends HttpServlet{
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
		String id = null;
		
		try{
			id = dao.idfind(name, birth);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		jo.put("mem_id", id);
		ja.add(jo);
		jo2.put("id", ja);
		
		resp.setContentType("text/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jo2);
		out.flush();
		out.close();
	}
}