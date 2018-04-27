import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//An instance of this class will read commands from the keyboard and it will send them to the server.
// The client stops when it reads from the keyboard the string "exit".
public class GameClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;

    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                client.sendRequestToServer(request);
            }
        }
    }

    private void sendRequestToServer(String request) throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // send a request to the server
        out.println(request);

        // receive response from server
        String response = in.readLine();
        System.out.println(response);
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}