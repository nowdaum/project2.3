package SSH.MEM.CONTROL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import SSH.DAO.MEMDAO;

@WebServlet("/LOGIN.do")
public class LoginControl extends HttpServlet{
	private MEMDAO dao;
	JSONObject jo;
	JSONArray ja;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		jo = new JSONObject();
		ja = new JSONArray();
		dao = new MEMDAO();
		
		try {
			jo = dao.login(id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession httpsession = req.getSession();

		if(((String)jo.get("mem_id")).equals(id)){
			httpsession.setAttribute("login", "1"); 
			httpsession.setAttribute("login_id", id); 
			httpsession.setAttribute("login_pw", pass); 
			httpsession.setAttribute("login_mnum", (String) jo.get("mem_num")); 
			httpsession.setAttribute("login_bnum", (String) jo.get("ban_num")); 
			httpsession.setAttribute("login_name", (String) jo.get("mem_name")); 
			httpsession.setAttribute("login_birth", (String) jo.get("mem_birth")); 
			httpsession.setAttribute("login_grade", (String) jo.get("mem_grade")); 
			httpsession.setAttribute("login_ph", (String) jo.get("mem_ph")); 
		}
		
		resp.setContentType("text/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jo);
		out.flush();
		out.close();
	}
}