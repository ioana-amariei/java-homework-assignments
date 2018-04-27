import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//An instance of this class will create a ServerSocket running at a specified port.
// The server will receive requests (commands) from clients and it will execute them.
public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.init();
        server.waitForClients();
        server.stop();
    }

    // while running is true, create a new socket for every incoming client
    // and start a ClientThread to execute its request.
    private void waitForClients() throws IOException {
        while (running) {
            System.out.println("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            // execute the client's request in a new thread
            new ClientThread(this, socket).start();
        }
    }

    //    create the serverSocket and set running to true
    private void init() throws IOException {
        try {

            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println(e);
        }

        running = true;
    }

    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
}
