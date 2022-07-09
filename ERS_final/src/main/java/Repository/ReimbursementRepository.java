package Repository;

import ConnectionFactory.SQLconnectionFactory;
import Nouns.*;

import java.sql.*;
import java.util.*;

public class ReimbursementRepository {

	public void Submit(Reimbursement reimb) {
		
		try(Connection connection = SQLconnectionFactory.getReimbursementConnection();){
			String sql = "insert into request_db(empID,fName,lName,reqAmt,status) values(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, reimb.getReqID());
			ps.setString(2, reimb.getFName());
			ps.setString(3, reimb.getLName());
			ps.setFloat(4, reimb.getReqAmt());
			ps.setString(5, reimb.getStatus());
			// add the time stampe later
			int row = ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Reimbursement> ViewOwn(Employee employee) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		Reimbursement reimby = new Reimbursement();
		try(Connection connection = SQLconnectionFactory.getReimbursementConnection();){
			//String sql = "select * from request_db inner join login_db on  ?"; should look up how to refer to ssn...
			String sql = "select * from request_db where empID=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employee.getID());
			//ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				//Reimbursement reimby = new Reimbursement();
				reimby.setReqID(rs.getInt("reqID"));
				reimby.setFName(rs.getString("fName"));
				reimby.setLName(rs.getString("lName"));
				reimby.setReqAmt(rs.getFloat("reqAmt"));
				reimby.setStatus(rs.getString("status"));
				reimbursementList.add(reimby);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return reimbursementList;
	}

}
