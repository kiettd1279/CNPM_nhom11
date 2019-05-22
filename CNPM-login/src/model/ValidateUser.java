package model;

import java.util.ArrayList;

public class ValidateUser {
	public static ArrayList<User> listUser = new ArrayList<>();

	public static ArrayList<User> getListUser() {
		User u1 = new User("KietTD", "nhoxdatinh1279@gmail.com", "123456");
		User u2 = new User("Thuy", "nhoxdatinh1279@gmail.com", "123456");
		User u3 = new User("Nhan", "nhoxdatinh1279@gmail.com", "123456");
		User u4 = new User("Phi", "nhoxdatinh1279@gmail.com", "123456");
		listUser.add(u1);
		listUser.add(u2);
		listUser.add(u3);
		listUser.add(u4);
		return listUser;

	}

	// 1 dung user sai pass -2 dug user dug pass -0 sai user
	public static int isValidate(User user) {
		for (int i = 0; i < listUser.size(); i++) {
			if (user.getUser().equals(listUser.get(i).getUser())) {
				if (user.getPassword().equals(listUser.get(i).getPassword())) {
					return 2;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}
	public static boolean inserUser(User user) {
		try {
			ValidateUser.getListUser().add(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		User test = new User("Phi", "nhoxdatinh1279@gmail.com", "123456");
		ValidateUser.getListUser();
		
		System.out.println(ValidateUser.isValidate(test));
		System.out.println(ValidateUser.inserUser(new User("Thien", "teo")));
//		for (int i = 0; i < listUser.size(); i++) {
//			System.out.println(listUser.get(i).getUser()+"   " +listUser.get(i).getPassword());
//			
//		}
		ValidateUser.inserUser(new User("Tam", "123"));
		System.out.println(ValidateUser.isValidate(new User("Tam", "123s")));
	}
	
}
