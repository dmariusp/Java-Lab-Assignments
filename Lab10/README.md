#Lab10's Assignment - Notes

## Compulsory

*[X] Create the project for the server application.

*[X] Implement the class responsible with the creation of a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.

*[X] Create a class that will be responsible with communicating with a client Socket. The communication will be on a separate thread. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".

*[X] Create the project for the client application.

*[X] A client will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".
 

## Optional

*[X] Create an object-oriented model for your application and implement the commands.The command stop should "gracefully" stop the server - it will not accept new connections but it will finish those in progress. When there are no more connections, it will shutdown.

*[X] Implement a timeout for a connection (a number of minutes). If the server does not receive any command from a logged in client in the specified period of time, it will terminate the connection.

*[ ] Create an HTML embeddable representation of the social network using JFreeChart, JGraphT and Apache Batik, or other technology.

*[ ] Upload the HTML representation directly from the application to a Web server. You may use JCraft for connecting to a server using SFTP and transferring a file (or a similar solution).


## Bonus

*[X] Implement an algorithm to determine the structural cohesion of the network.