package Web;

import Nouns.*;
import Repository.ReimbursementRepository;
import Repository.EmployeeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/emp-requests"})

public class RequestController extends HttpServlet {

    ReimbursementRepository reimRepo = new ReimbursementRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        /*
        System.out.println(session.isNew());
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));
        */
		
        Employee currentUser = (Employee) session.getAttribute("current-user");
        
//        System.out.println(currentUser);
        
        if(currentUser != null) {
            String reURI = req.getRequestURI();
            // read
            if (reURI.equals("/system/requests")) {
                List<Reimbursement> rqsts = reimRepo.ViewOwn(currentUser);// how to pass the employee object at least?
                req.setAttribute("all-requests", rqsts);
                req.getRequestDispatcher("request-list.jsp").forward(req, resp);
            }
            if (reURI.equals("/employee-reimbursement-system-v2/webapp/delete-request")) { // check address
                String id = req.getParameter("id");
               // reimRepo.delete(Integer.parseInt(id)); you won't have to delete any.
                resp.sendRedirect("requests");
            }
        }else{
            resp.sendRedirect("login.html");
        }
    }

    
    // yeah you need to roll your own and understand meaning of http and servlet...
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("ReqAmt");
        Reimbursement rqst = new Reimbursement();
        rqst.setUsername(name);
        rqst.setReqAmt(Float.parseFloat(price));
        reimRepo.Submit(rqst);
        resp.sendRedirect("requests");

    }
}
