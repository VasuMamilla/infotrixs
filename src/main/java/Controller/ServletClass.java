package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DaoClass;
import Model.DtoClass;
@WebServlet(urlPatterns = {"/addlink","/displaylink","/deletelink"})
public class ServletClass extends HttpServlet {
	DaoClass da1=new DaoClass();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		switch (path) {
		case "/addlink":
			addEmp(req,resp);
			break;

		case "/displaylink":
			displayEmp(req,resp);
			break;
			
		case "/deletelink":
			deleteEmp(req,resp);
			break;
		
		}
		
	}

	private void deleteEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		DtoClass dt1=new DtoClass();
		dt1.setId(id);
		int res=da1.deleteemp(dt1);
		req.setAttribute("result", res);
		RequestDispatcher rd=req.getRequestDispatcher("delete.jsp");
		rd.forward(req, resp);
		
	}

	private void displayEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<DtoClass> res=da1.display();
		RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
		req.setAttribute("result", res);
		rd.forward(req, resp);
	}

	private void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("sal"));
		
		DtoClass dt1=new DtoClass();
		dt1.setId(id);
		dt1.setName(name);
		dt1.setSal(sal);
		
		int res=da1.addemp(dt1);
		req.setAttribute("result", res);
		RequestDispatcher rd=req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	
}
