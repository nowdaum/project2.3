package SSH.MEM.CONTROL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LOGOUT.do")
public class LogoutControl extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		HttpSession httpsession = req.getSession();
		
		httpsession.removeAttribute("login");
		httpsession.removeAttribute("login_id");
		httpsession.removeAttribute("login_pw");
		httpsession.removeAttribute("login_mnum");
		httpsession.removeAttribute("login_bnum");
		httpsession.removeAttribute("login_name");
		httpsession.removeAttribute("login_birth");
		httpsession.removeAttribute("login_grade");
		httpsession.removeAttribute("login_ph");
		
		httpsession.setAttribute("login", "0");
		
		resp.sendRedirect("/project2/content/main.jsp");
	}
}