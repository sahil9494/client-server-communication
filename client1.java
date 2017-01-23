//package demo;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client1 {

public static void main(String[]args) throws Exception{

Scanner in = new Scanner(System.in);
//create a socket to initiate connection with the server on the same port that is assigned in the server class
//create a server socket to listen on port

Socket sock= new Socket("localhost",2700);

OutputStreamWriter os= new OutputStreamWriter(sock.getOutputStream());
PrintWriter out= new PrintWriter(os);


InputStreamReader IR= new InputStreamReader(sock.getInputStream());
BufferedReader BR= new BufferedReader(IR);



String message= BR.readLine();
System.out.println("C1: Data from server = "+message);
//to server


String line= "CLIENT_PORT $ "+sock.getPort();
out.println(line);
out.flush();
sock.close();

// here begins the client connection with another client

ServerSocket sockforclients= new ServerSocket(15000);
Socket newsock=sockforclients.accept();// accept the request from client 2 to connect and facilitate


InputStreamReader IR1= new InputStreamReader(newsock.getInputStream());
BufferedReader BR1= new BufferedReader(IR1);


OutputStreamWriter os1= new OutputStreamWriter(newsock.getOutputStream());
PrintWriter out1= new PrintWriter(os1);


String m1="";
System.out.println("Type a message");
m1= in.nextLine();

try{
while(!m1.equals("exit")){

	out1.println(m1);
	out1.flush();
	
String readreply=BR1.readLine();

// read what the other client sent

System.out.println("C2: " +readreply);

if(readreply.equals("exit")){
	System.out.println("Chat session ended by client2");
	break;
}
System.out.println("Type a reply please:");
m1 = in.nextLine();

}
}
catch (Exception e){
	System.out.println("Chat Session has finished");
}
newsock.close();

}
}
