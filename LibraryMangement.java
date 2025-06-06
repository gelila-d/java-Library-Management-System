import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMangement {

ArrayList<String> st = new ArrayList<String>();

LibraryMangement(){ 
try{
Store_data();
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}


public void addBook(String data)throws FileNotFoundException{
try (FileWriter f = new FileWriter("Book_Detail.txt", true);
BufferedWriter b = new BufferedWriter(f);
PrintWriter p = new PrintWriter(b);) 
{ 
if(!check(data)) {
p.println(data);
st.add(data);
}

} catch (IOException i) {
i.printStackTrace(); 
}

}


public boolean check(String s) throws FileNotFoundException{

int j=0;
String sub_data1[] = s.split("-");

if(st.isEmpty()) {
return false;
}
while(j!=st.size()) {
String sub_data[];
sub_data = st.get(j).split("-");
if(sub_data[0].equals(sub_data1[0])&&sub_data[1].equals(sub_data1[1])&&
sub_data[2].equals(sub_data1[2])&&sub_data[3].equals(sub_data1[3])){
int val1 = Integer.parseInt(sub_data[4]);
val1 = val1 + Integer.parseInt(sub_data1[4]);
sub_data[4] = Integer.toString(val1);

int val2 = Integer.parseInt(sub_data[5]);
val2 = val2 + Integer.parseInt(sub_data1[5]);
sub_data[5] = Integer.toString(val2);

String st1 = sub_data[0];
for(int i=1;i<6;i++) {
st1 = st1+"-"+sub_data[i];
}
st.set(j,st1);
write_data();
return true;
}
j++;
}
return false;

}


public  void Store_data() throws FileNotFoundException{
Scanner scanner = new Scanner(new File("Book_Detail.txt"));

while (scanner.hasNextLine()) {
st.add(scanner.nextLine());
}

}


public void write_data() {
try (FileWriter f = new FileWriter(new File("Book_Detail.txt"));
BufferedWriter b = new BufferedWriter(f);
PrintWriter p = new PrintWriter(b);) 
{ 
for(int i=0;i<st.size();i++) {
p.println(st.get(i));
}
} catch (IOException i) {
i.printStackTrace(); 
}
}


public ArrayList<String> SearchingBook(String title){
ArrayList<String> SearchData = new ArrayList<String>();
int length_of_title = title.length();
int j=0;
while(j!=st.size()) {
String sub_data[];
sub_data = st.get(j).split("-");

if(sub_data[1].length()>=length_of_title && length_of_title!=0 ){
String data = sub_data[1].substring(0, length_of_title);
if(data.equals(title))
SearchData.add(st.get(j));
}
j++;
}
return SearchData;
}


public boolean IssuingBook(int bookID) {

String s = Integer.toString(bookID);
int j=0;
while(j!=st.size()) {
String sub_data[];
sub_data = st.get(j).split("-");
if(sub_data[0].equals(s)){
if(Integer.parseInt(sub_data[5])>0) {
int val1 = Integer.parseInt(sub_data[5]);
sub_data[5] = Integer.toString(val1-1);

String st1 = sub_data[0];
for(int i=1;i<6;i++) {
st1 = st1+"-"+sub_data[i];
}
st.set(j,st1);
write_data();
return true;
}
else {
return false;
}

}
j++;
}

return false;

}


public boolean returningBook(int bookID) {
String s = Integer.toString(bookID);
int j=0;
while(j!=st.size()) {
String sub_data[];
sub_data = st.get(j).split("-");
if(sub_data[0].equals(s)){

if(Integer.parseInt(sub_data[4])>Integer.parseInt(sub_data[5])) {
int val1 = Integer.parseInt(sub_data[5]);
sub_data[5] = Integer.toString(val1+1);

String st1 = sub_data[0];
for(int i=1;i<6;i++) {
st1 = st1+"-"+sub_data[i];
}
st.set(j,st1);
write_data();
return true;
}

else {
return false;
}

}
j++;
}

return false;
}

public void viewAllBooks() {
String fileName = "Book_Detail.txt";
try (Scanner scanner = new Scanner(new File(fileName))) {
    System.out.println("ID-Title-Publisher-Author-Total copies-Copies available");
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
    }
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + fileName);
}
}

}