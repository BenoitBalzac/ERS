package Web;

import at.favre.lib.crypto.bcrypt.BCrypt;
import Nouns.Employee;
import Repository.EmployeeRepository;

public class Login {
	
	EmployeeRepository emp_repo=new EmployeeRepository();
	
	public static boolean Authorize(String username, String password) {
		Employee emp = EmployeeRepository.searchByUsername(username);
		if(emp == null)
			return false;
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),emp.getPassword());
		if (result.verified) {
			return true;
		}else {
			return false;
		}
	}

}
