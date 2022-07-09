package Repository;

import Nouns.Employee;

import Nouns.EmployeeType;
import Nouns.Reimbursement;
import ConnectionFactory.SQLconnectionFactory;
import ConnectionFactory.SQLconnectionFactory.*;

import java.sql.*;
import java.util.*;

public class EmployeeRepository {
	
	public static Employee searchByUserID(int eID) {
		Employee eeh = new Employee();
		
		try (Connection connection = SQLconnectionFactory.getLoginConnection()){
			String sql = "select * from login_db where empID =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,eID);
			ResultSet rs = ps.executeQuery(sql);
			if(rs.next()) {
				//Employee eeh = new Employee();
				eeh.setID(rs.getInt("empID"));
				eeh.setFName(rs.getString("fName"));
				eeh.setLName(rs.getString("lName"));
				eeh.setPassword(rs.getString("password"));
				//eeh.getEmployeeType() come back later
				return eeh;
			} 
		}catch (SQLException e) {
				e.printStackTrace();
			}return eeh;
		}
	
	public static Employee searchByUsername(String username) {
		
		Employee eeh = new Employee();
		
		try (Connection connection = SQLconnectionFactory.getLoginConnection()){
			String sql = "select * from login_db where empID =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery(sql);
			if(rs.next()) {
				//Employee eeh = new Employee();
				eeh.setID(rs.getInt("empID"));
				eeh.setUsername(rs.getString("username"));
				eeh.setFName(rs.getString("fName"));
				eeh.setLName(rs.getString("lName"));
				eeh.setPassword(rs.getString("password"));
				//eeh.getEmployeeType() come back later
				return eeh;
			} 
		}catch (SQLException e) {
				e.printStackTrace();
			}return eeh;
		} 
	
	
	}


