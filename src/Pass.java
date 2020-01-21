import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;


public class Pass {
	//global variable
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		boolean quit = false;
		//create two str
		ArrayList<String> users = new ArrayList<String>();
		ArrayList<String> pass = new ArrayList<String>();
		do {
			System.out.println("1. Sign Up");
			System.out.println("2. Log In");
			System.out.println("3. Quit\n");
			int answer = scan.nextInt();
			switch (answer) {
			case 1: {
				signUp(users,pass);
				break;
			}
			case 2: {
				logIn(users, pass);
				break;
			}
			case 3: {
				quit = quitNow(quit);
				break;
			}

			default: {
				System.out.println("hi");
				break;
			}
			}

		} while (!quit);
		System.out.println("\nThank you for enjoying our program.");
		System.out.println("--END OF PROGRAM--");
	}

	public static void signUp (ArrayList<String> users, ArrayList<String> pass) {
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
		System.out.println("\nCreate your username:");
		String usern = scan.next(); 
		System.out.println("\nCreate your password:");
		boolean that = true;
		 do {
		String passw = scan.next(); 

			if(passw.length() < 6) {
				System.out.println( "Please re-enter your password:");
			}
	
			else {
				if (passw.matches(pattern)) { // how do I use regexs
					System.out.println("Thank you");
					 users.add(usern);
					 pass.add(passw);
					that = false; 
				}
				else {
					System.out.println("\nPlease re-enter your pass");
				}
			}
		} while (that);
		 
	}

	public static void logIn(ArrayList<String> users, ArrayList<String> pass) {
		//prompt to enter username and pass
		System.out.print("\nUsername: ");
		String username = scan.next();  
		System.out.print("\nPassword: ");
		String password = scan.next();
		boolean correct = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).equals(username) && pass.get(i).equals(password)) {
				System.out.println("\nYou have been logged in! Your account balance is -$100. You owe us, we will find you and encrypt all your files.\n Please do not hack us in return.\n");
				correct = true; 
			}
		}
		if (!correct) {
			System.out.println("Wrong username or password! Try again.");
		}
	}

	public static boolean quitNow(boolean quit) {
		quit = true;
		return quit;
	}
}
