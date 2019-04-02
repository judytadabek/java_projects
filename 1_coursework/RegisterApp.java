package main;

import lib.Name;
import lib.Register;

public class RegisterApp {


	public static String execute(Register reg, Name n) {	
		//Name n1 = new Name();
		//Name n2 = new Name();
		//Name n3 = new Name();
		
		//reg.addName(n1); //index 0
		//reg.addName(n2); //index 1
		//reg.addName(n3); //index 2
		
		reg.removeName(1);
		reg.addName(n);
		
		

		return reg.getName(0).getFamilyName().toUpperCase() + ", " + reg.getName(0).getFirstName().charAt(0) + "\n"
				+ reg.getName(1).getFamilyName().toUpperCase() + ", " + reg.getName(1).getFirstName().charAt(0) + "\n"
				+ n.getFamilyName().toUpperCase() + ", " + n.getFirstName().charAt(0) + "\n";			
	}
}

