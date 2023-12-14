package controller;

import model.User;

public class UserController {
	public static boolean isAlphanumeric(String foo) {
		int alp = 0;
		int num = 0;
		for (int i = 0; i < foo.length(); i++) {
			if (alp != 0 && num != 0)
				return true;
			if (Character.isAlphabetic(foo.charAt(i)))
				alp++;
			if (Character.isDigit(foo.charAt(i)))
				num++;
		}
		return false;
	}
	
	public static void login(String name, String pass) {
//		if (User.checkUsernameAndPassword(name, pass)) {
//			
//		}
	}

	public static void registerUser(String name, String pass, String coPass, int age) {
			if(name.length() < 7) {
				System.err.println("Name must be 7 or more characters");
				return;
			}
			
			if(!isAlphanumeric(pass)) {
				System.err.println("Password is not alphanumeric");
				return;
			}
			
			if(pass.length() < 6) {
				System.err.println("Password is too short(minimal length 6)");
				return;
			}
			
			if(!pass.equals(coPass)) {
				System.err.println("Password doesn't match confirmation pass");
				return;
			}
			
			if(age < 13 || age > 65) {
				System.err.println("Age have to be between 13 and 65");
				return;
			}
			
			User.create(new User(name, pass, coPass, age));
	}
}
