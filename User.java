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

System.out.print("Enter username: ");
try{
username = sc.nextLine();
if (!username.matches("[a-zA-Z]+")) {
throw new InputMismatchException("Username must contain letters only , enter again ");

}
if (username.isEmpty()) {
  throw new InputMismatchException("Username cannot be empty");
}
}

catch(InputMismatchException e) {
System.out.println("Error: " + e.getMessage());
System.out.println("Username cannot be empty");
System.out.println("Enter your username again");
username = sc.nextLine();



}


System.out.print("Enter password: ");
try{
password = sc.nextLine();

if (password.isEmpty()) {
throw new InputMismatchException("Password cannot be empty");
}}
catch(InputMismatchException e) {
System.out.println("Error: " + e.getMessage());
System.out.println("Password cannot be empty");
System.out.println("Enter your password again");
password = sc.nextLine();
}
} 

}
