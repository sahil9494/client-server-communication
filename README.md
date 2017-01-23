# client-server-communication


This program will implement a client-server communication, in which two clients connect to the server one by one. 
The first client will send a connection request to the server and will get a reply "Wait" from the server, which simply means that the server is waiting on another connection to connect.Also, the client one will send information about the sever it is connected to(ip address) and the port on which it is connected on back to the server.Once, another client(client2) sends a request to the server, the server sends information about client1's connection to client 2, so client2 can connect to client 1. Once, the clients have connected to each other, they can chat for however long they wish to. If one of them decides to stop the conversation, it can be done by entering "exit" as a message to another client.
