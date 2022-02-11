package store;

import java.util.Scanner;

import mgr.Manageable;

public class Admin implements Manageable {
    private String adminId;
    private String pwd;

	public void read(Scanner scan) {
    	adminId = scan.next();
    	pwd = scan.next();
	}

	public void print() {
        System.out.printf("[%s] %s\n", adminId, pwd);
	}

	public boolean matches(String kwd) {
		if (adminId.equals(kwd))
			return true;
		return false;
	}
	
	public boolean passwordMatch(String password) {
		if(pwd.equals(password))
			return true;
		return false;
	}
		public String getinfo() {
		String kwd;
		kwd = adminId + " " + pwd;
		
		return kwd;
		
	}
}