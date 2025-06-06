import java.util.InputMismatchException;
import java.util.Scanner;
public class User {

private String username;
private String password;



public User(String username, String password) {
this.username = username;
this.password = password;}


public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}
public static void main(String args[]) {
login();
}

public static void login() {
    Scanner sc = new Scanner(System.in);
    String username = "";
    String password = "";

    try {
        System.out.print("Enter username: ");
        username = sc.nextLine();
        if (username.isEmpty()) {
            throw new InputMismatchException("Username cannot be empty");
        }
        if (!username.matches("[a-zA-Z]+")) {
            throw new InputMismatchException("Username must contain letters only ");
        }

        System.out.print("Enter password: ");
        password = sc.nextLine();

        if (password.isEmpty()) {
            throw new InputMismatchException("Password cannot be empty");
        }
    } catch (InputMismatchException e) {
        System.out.println("Error: " + e.getMessage());
        return;
    }
    System.out.println("Login successful for user: " + username);
}}