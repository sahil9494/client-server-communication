//package demo;

import java.util.*;

import java.net.*;
import java.io.*;

public class client2 {

public static void main(String[] args) throws Exception{
Scanner in = new Scanner(System.in);
Socket sock= new Socket("localhost",2700);

OutputStreamWriter os= new OutputStreamWriter(sock.getOutputStream());
PrintWriter out=new PrintWriter(os);

InputStreamReader IR= new InputStreamReader(sock.getInputStream());
BufferedReader BR= new BufferedReader(IR);

String line= BR.readLine();
System.out.println("Server: " +line);

sock.close();

// here begins the client connection with another client


Socket newsocket=new Socket("localhost",15000);

InputStreamReader ir=new InputStreamReader(newsocket.getInputStream());
BufferedReader br= new BufferedReader(ir);

OutputStreamWriter os1= new OutputStreamWriter(newsocket.getOutputStream());
PrintWriter out1= new PrintWriter(os1);

String incomingtext = br.readLine();

try{

while(!incomingtext.equals("exit")){


System.out.println("C1: " +incomingtext);


System.out.println("Type a reply to client1 ");
String reply=in.nextLine();
if(reply.equals("exit")){
	System.out.println("Chat session ended");
	break;
}

out1.println(reply);
out1.flush();


incomingtext = br.readLine();

}


}
catch(Exception e){
	System.out.println("Chat session has finished");
}

newsocket.close();
}
}

