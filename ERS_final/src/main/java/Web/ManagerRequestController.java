package Web;

import Nouns.Reimbursement;

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

@WebServlet(urlPatterns = {"/mgr-requests"})
public class ManagerRequestController extends HttpServlet {
	
	EmployeeRepository meh = new EmployeeRepository();
	ReimbursementRepository reimRepo = new ReimbursementRepository();

    //@Override
    // protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{ // can I roll in one?
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        /*
        System.out.println(session.isNew()); 
        System.out.println(session.getId());
        System.out.println(new Date(session.getCreationTime()));
        System.out.println(new Date(session.getLastAccessedTime()));
        */
        
        
        // Manager should be able to Approve, Deny, then each action redirects to the updated page.

        String currentUser = (String) session.getAttribute("current-user");
        System.out.println(currentUser);
        if(currentUser != null) {
            String reURI = req.getRequestURI();
            // read
            if (reURI.equals("/ERS_final/requests")) {
                List<Reimbursement> rqsts = reimRepo.ViewOwn(currentUser); // here we want the Manager to view reimbursement by employee ID, 
                req.setAttribute("all-requests", rqsts);
                req.getRequestDispatcher("request-list.jsp").forward(req, resp);
            }
            /*if (reURI.equals("/employee-reimbursement-system-v2/delete-request")) {
                String id = req.getParameter("id");
                //reimRepo.delete(Integer.parseInt(id)); YOu don't want to delete, buttons to point to status update
                resp.sendRedirect("requests");
            }
            */
        }else{
            resp.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String atm = req.getParameter("reqAmt");
        Reimbursement rqt = new Reimbursement();
        rqt.setUsername(name);
        rqt.set(Double.parseDouble(atm));
        rqt.save();
        resp.sendRedirect("requests");

    }

}
