import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String companySuffix = "lcup.com";
	private int mailBoxCapacity = 100;
	private int defaultPasswordLength = 8;
	private String alternateEmail;
	
	//constructor for names
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Account Applicant: " + this.firstName + " " + this.lastName);
		
		//department
		this.department = setDepartment();
		
		//generate random password
		this.password = generateRandomPassword(defaultPasswordLength);
		
		//generate email
		email = this.lastName.toLowerCase() + "." + this.firstName.toLowerCase() + "@" + this.department.toLowerCase() + "." +  companySuffix;

	}
	
	private String setDepartment() {
		System.out.print("Enter department:\n0 None \n1 Sales \n2 Development \n3 Accounting \nPick department: ");
		Scanner enterNum = new Scanner(System.in);
		int dep = enterNum.nextInt();
		if(dep == 1) { return "Sales"; }
		else if (dep == 2) { return "Development"; }
		else if(dep == 3) { return "Accounting"; }
		else { return ""; }
	}
	
	private String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		return new String (password);
	}
	
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail; 
	}
	
	public void changePassword(String setPassword) {
		this.password = setPassword;
	}

	public void setPasswordLength(int length) {
		this.defaultPasswordLength = length;
	}
	
	public int getMailBoxCapacity() { return mailBoxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword() { return password; }
	
	
	public String showInfo() {
		return "FULL NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailBoxCapacity;  
	}
	
}
