import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final GameServer server;

    // Create the constructor that receives a reference to the server and to the client socket
    public ClientThread(GameServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    public void run() {
        BufferedReader in = null; //client -> server stream
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String request = null;
        try {
            request = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = execute(request);

        PrintWriter out = null; //server -> client stream
        try {
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(response);
        out.flush();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String execute(String request) {
        String response = "Server received the request: " + request;
        System.out.println(request);

        return  response;
    }
}