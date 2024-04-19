package loginpjr;

/**
 *
 * @author phenyo
 */

import java.util.Scanner;

public class Login {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;

    // Constructor
    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check if username meets format requirements
    public boolean checkUserName() {
        return username.matches("^\\w{1,5}$");
    }

    // Method to check if password meets complexity requirements
    public boolean checkPasswordComplexity() {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$");
    }

    // Method to register user
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        return "User successfully registered.";
    }

    // Method to log in user
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    // Method to return login status message
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        // Create a new user
        Login user = new Login(username, password, firstName, lastName);

        // Test registration
        System.out.println(user.registerUser());

        // Test login
        System.out.println("Enter username to login:");
        String loginUsername = scanner.nextLine();

        System.out.println("Enter password to login:");
        String loginPassword = scanner.nextLine();

        System.out.println(user.returnLoginStatus(loginUsername, loginPassword));
    }
}
