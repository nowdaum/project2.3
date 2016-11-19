package SSH.FINDHEWON.CONTROL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SSH.DAO.FINDHEWONDAO;
import SSH.DTO.FINDHEWONDTO;

@WebServlet("/INSERTFINDHEWON.do")
public class InsertFindHewonControl extends HttpServlet{
	private FINDHEWONDAO dao;
	private ArrayList<FINDHEWONDTO> list;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}