//package demo;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class server {

public static void main(String[]args) throws Exception{

ServerSocket srsock= new ServerSocket(2700);

// socket to connect to client 1

Socket sock1= srsock.accept();// when server accepts the request from client1, a random port is assigned to client1 to carry out future communication


// socket to connect to client 2

Socket sock2=srsock.accept();// when server accepts the request from client2, a random port is assigned to client1 to carry out future communication



// data from client 1
InputStreamReader IR= new InputStreamReader(sock1.getInputStream());
BufferedReader BR= new BufferedReader(IR);

//data to client 1
OutputStreamWriter os= new OutputStreamWriter(sock1.getOutputStream());
PrintWriter out= new PrintWriter(os);


// send a wait command to client 1

out.println("WAIT");
out.flush();

//data from client 2
InputStreamReader IR1= new InputStreamReader(sock2.getInputStream());
BufferedReader BR1= new BufferedReader(IR1);

//data to client 2
OutputStreamWriter os1= new OutputStreamWriter(sock2.getOutputStream());
PrintWriter out1= new PrintWriter(os1);

// read what client 1 sent and output it

String line= BR.readLine();
System.out.println("C1->"+line);
// send the details of connection to client 2
out1.println("PEER_LOC $"+sock1.getInetAddress()+" $ "+sock1.getPort());
out1.flush();

// terminates the connection
sock1.close();
sock2.close();

}

}
