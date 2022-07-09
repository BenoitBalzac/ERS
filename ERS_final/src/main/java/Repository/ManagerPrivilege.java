package Repository;

import ConnectionFactory.*;
import Nouns.*;

import java.sql.*;
import java.util.*;

public class ManagerPrivilege {
	
	public void Approve(Reimbursement reimb) {
		try (Connection connection = SQLconnectionFactory.getReimbursementConnection();) {
			String sql = "update request_db set status = ? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ReimbursementStatus.APPROVED.name() );
			int row = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Deny(Reimbursement reimb) {
		try (Connection connection = SQLconnectionFactory.getReimbursementConnection();) {
			String sql = "update request_db set status = ? where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ReimbursementStatus.DENIED.name() );
			ps.setInt(2, reimb.getReqID());
			int row = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Reimbursement> ViewAll(Employee employee,Reimbursement rimb) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		Reimbursement reimby = new Reimbursement();
		try(Connection connection = SQLconnectionFactory.getReimbursementConnection();){
			String sql = "select * from request_db";
			PreparedStatement ps = connection.prepareStatement(sql);
			//ps.setInt(1, employee.getID());
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
