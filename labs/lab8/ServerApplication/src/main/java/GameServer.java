import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//An instance of this class will create a ServerSocket waitingForClientConnections at a specified port.
// The server will receive requests (commands) from clients and it will execute them.
public class GameServer {
    private ServerSocket serverSocket;
    private boolean waitingForClientConnections = false;
    public static int aliveConnections = 0;

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.init();
        server.waitForClients();
    }

    //    create the serverSocket and set waitingForClientConnections to true
    private void init() throws IOException {
        serverSocket = new ServerSocket(8100);
        waitingForClientConnections = true;
    }

    // while waitingForClientConnections is true, create a new socket for every incoming client
    // and start a ClientThread to execute its request.
    private void waitForClients() throws IOException {
        while (waitingForClientConnections) {
            System.out.println("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            // execute the client's request in a new thread
            new ClientThread(this, socket).start();
        }
    }

    public void stop() throws IOException {
        waitingForClientConnections = false;
        while (aliveConnections > 0){}
        serverSocket.close();
    }
}
