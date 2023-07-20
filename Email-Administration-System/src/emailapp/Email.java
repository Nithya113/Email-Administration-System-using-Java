 package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private String email;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "xyzcompany.com";
	
	// Construct to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		// call a method asking for the department - return the department
		this.department = setDepartment();
		
		
		// call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is : "+ this.password);
		
		
		// combine elements to email
		email = firstName.toLowerCase() + "." + lastName .toLowerCase() + "@" + department +"." + companySuffix;
		
	}
	
	// ask for department
	private String setDepartment() {
		System.out.print("DEPARTMENTS CODES : \n1. Sales\n2. Development\n3. Accountant\n0. None\nEnter Department from above codes: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1)	return "sales";
		else if(depChoice == 2)	return "dev";
		else if(depChoice == 3)	return "acct";
		else return "";
		
		
	}
	// generate random password
	public String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$%";
		char[] password = new char[length];
		
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] =  passwordSet.charAt(rand); 
		}
		return new String(password);
	}
	
	
	// set mailbox capacity
	public void setMailCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// set alternative email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + lastName+ 
				"\nCOMPANY EMAIL:" + email +
				"\nMAILBOX COMPACITY: "+ mailboxCapacity + "mb"; 
	}
		
}
