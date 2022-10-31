package edu.ucdenver.server;
import java.io.*;
import java.net.*;
import java.net.Socket;
import edu.ucdenver.morse.Morse;

public class Server implements Runnable{
    int port;
    int backlog;
    int connectionCounter;
    Boolean keepServerRunning = true;
    ServerSocket socketServer;
    Socket connection;
    ObjectOutputStream output; // output stream to client
    ObjectInputStream input;

    Server(int port, int backlog){
        this.port = port;
        this.backlog = backlog;
    }

    public void run(){
        try {
            ServerSocket server = new ServerSocket(12345, 100);
            while (keepServerRunning == true) {
                connection = waitForConnection();
                getInputStream(connection);
                getOutputStream(connection);
                sendMessage(processClientMessage("E|waffle"),getOutputStream(connection));

            }
            closeConnection(connection, getInputStream(connection), getOutputStream(connection));
            connectionCounter++;
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }

    }


    public Socket waitForConnection() throws IOException{
        displayMessage("Waiting for connection\n");
        connection = socketServer.accept();
        displayMessage("Connection" + connectionCounter + "recieved from: "+ connection.getInetAddress().getHostName());
        return connection;
    }

    public void displayMessage(String message){
        System.out.println(message);

    }

    public PrintWriter getOutputStream(Socket s) throws IOException{
        ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
    }

    public BufferedReader getInputStream(Socket s) throws IOException{
        
    }

    public void closeConnection(Socket s, BufferedReader b, PrintWriter p){

    }

    public void sendMessage(String str, PrintWriter p){

    }

    public String processClientMessage(String str){
        Morse morse = new Morse();
        if(str.charAt(0) == 'E'){
            String newStr = str.substring(2,str.length());
            if(newStr.isEmpty()){
                return "2|Invalid Message Format";
            }
            else {
                String serverResponse = "0|" + morse.encode(newStr);
                return serverResponse;
            }
        }
        if(str.charAt(0) == 'D'){
           String newStr = str.substring(2,str.length());
            if(newStr.isEmpty()){
                return "2|Invalid Message Format";
            }
            else {
                String serverResponse = "0|" + morse.decode(newStr);
                return serverResponse;
            }
        }
        else{
            return "1|Not Implemented";
        }

    }
}
