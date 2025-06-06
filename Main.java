import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
LibraryMangement Libraray = new LibraryMangement();
System.out.println("| Welcome to Library Management System |");
System.out.println("Enter 1 if you are a Librarian");
System.out.println("Enter any number if you are a User");
int userType ;
try{
userType = sc.nextInt();}
catch(Exception e) {
	System.out.println("Please enter a  number");
	return;
}

if(userType == 1) {
	System.out.println("librarian login required");
	User.login();}
else{
	System.out.println("User login required");
	User.login();
}

while(true) {
	clear.clearScreen();
System.out.println("+--------------------------+");
System.out.println("| Library Mangement System |");
System.out.println("+--------------------------+\n");
System.out.println("---------------------------------");

System.out.println("Enter 1 for Returning a Book");
System.out.println("Enter 2 for Searching a Book");
System.out.println("Enter 3 for Issuing a Book");
if(userType == 1) {
		System.out.println("Enter 4 for Adding a Book");
		System.out.println("Enter 5 to view all books");
}
System.out.println("Enter 6 to exit");

System.out.println("---------------------------------");
System.out.print("Please Enter your choice : ");

int choice;
try{
choice = sc.nextInt();}
catch(Exception e) {
System.out.println("Please enter a valid number");
return;
}
System.out.println("---------------------------------");


if(choice == 4 && userType == 1) {
int ID , totalCopies;
String Title , Publisher , Author;

System.out.print("Enter Book ID : ");
ID = sc.nextInt();
Title = sc.nextLine();

System.out.print("Enter Book Title : ");
Title = sc.nextLine();

System.out.print("Enter name of Publisher : ");
Publisher = sc.nextLine();

System.out.print("Enter Author name : ");
Author = sc.nextLine();

System.out.print("Enter total number of copies: ");
totalCopies = sc.nextInt();

String data = Integer.toString(ID)+"-"+Title+"-"+Publisher+
		"-"+Author+"-"+Integer.toString(totalCopies)+"-"+Integer.toString(totalCopies);

try {

	Libraray.addBook(data); //Adding the data

} catch (FileNotFoundException e) {
	e.printStackTrace();
}
System.out.println("---------------------------------");
System.out.println("Successfully book added");
System.out.println("Thank you!");


}



else if(choice == 2) {
String s = sc.nextLine();
System.out.print("Enter book title name : ");
String title = sc.nextLine();
System.out.println("---------------------------------");
title.toLowerCase();

ArrayList<String> searchData = new ArrayList<String>();

searchData = Libraray.SearchingBook(title);
//searching the data

System.out.println("Searched book detail : ");
System.out.println("ID-Title-Publisher-Author-Total copies-Copies available\n");
for(int i=0;i<searchData.size();i++) {
	System.out.println(searchData.get(i));
}

int x = 0;
if( !searchData.isEmpty()) {
System.out.println("-------------------------------------------");
System.out.print("If you want a book enter 1 else enter 0 : ");
x = sc.nextInt();
}
else {
	System.out.println("Book is not available");
}

if(x == 1) {
		System.out.println("-------------------------------------------");
	System.out.print("Enter book ID : ");
	int bookID = sc.nextInt();
	System.out.println("---------------------------------");

	Libraray.IssuingBook(bookID);
	//Issuing the book given ID

	System.out.println("Book successfully issued");
	System.out.println("Thank you!");

}
else {
		System.out.println("-------------------------------------------");
	System.out.println("Thank you!");
}

}




else if(choice == 3) {
System.out.print("Enter book ID : ");
int bookID = sc.nextInt();
System.out.println("---------------------------------");

//Issuing the book given ID
if(Libraray.IssuingBook(bookID)) {
System.out.println("Book successfully issued");
}
else {
	System.out.println("Book is not available");
}
System.out.println("Thank you!");
}




else if(choice == 1) {
System.out.print("Enter book ID : ");
int bookID = sc.nextInt();
System.out.println("---------------------------------");

//returning the book given ID
if(Libraray.returningBook(bookID)) {
System.out.println("Book successfully returned");
}
else {
	System.out.println("This book ID is not valid");
}
System.out.println("Thank you!");
}

else if(choice == 5 && userType == 1) {


System.out.println("All books in the library are : ");
Libraray.viewAllBooks();}

else if(choice == 6) {
	System.exit(0);}
else {
System.out.println("Enter valid choice");
}

}

}
}