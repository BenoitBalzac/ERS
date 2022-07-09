package Web;

import Repository.EmployeeRepository;
import Web.Login;
import ConnectionFactory.SQLconnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	protected HttpServletRequest req;
	protected HttpServletResponse resp;
	

    EmployeeRepository eRepo=new EmployeeRepository();

    //Connection el_connect= new getLoginConnection();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//HttpSession session=req.getSession();
    	resp.sendRedirect("Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username=req.getParameter("username");
        String password=req.getParameter("password");

       boolean b=Login.Authorize(username,password);
       if(!b){
           resp.sendRedirect("login.jsp");
       }else{
           HttpSession session=req.getSession();
/*
           System.out.println(session.isNew());
           System.out.println(session.getId());
           System.out.println(new Date(session.getCreationTime()));
           System.out.println(new Date(session.getLastAccessedTime()));
*/			
           session.setAttribute("current-user",username);

           resp.sendRedirect("request-list-emp.jsp");
       }
    }
}