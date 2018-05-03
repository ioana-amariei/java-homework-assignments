import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//An instance of this class will read commands from the keyboard and it will send them to the server.
// The client stops when it reads from the keyboard the string "exit".
public class GameClient {
    private int max;
    private Socket socket;
    PrintWriter out;
    BufferedReader in;

    public GameClient() throws IOException {
        socket = new Socket("127.0.0.1", 8100);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        client.start();
    }

    public void start() throws IOException {
        while (true) {
            String request = readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                sendRequestToServer(request);
            }
        }
    }

    private void sendRequestToServer(String command) throws IOException {
        if (command.equals("create")) {
            sendCreateRequest(out);
            System.out.println(in.readLine());
        } else if (command.equals("submit")) {
            sendSubmitRequest(out);
            System.out.println(in.readLine());
        } else if (command.equals("quit")) {
            out.println("quit");
            System.out.println(in.readLine());
        } else {
            System.out.println("Not a valid command");
        }
    }

    private void sendSubmitRequest(PrintWriter out) {
        out.println("submit");

        int number = 0;
        while (number <= 1 || number >= max) {
            System.out.println("Enter a number between 1 and " + max);
            number = Integer.parseInt(readFromKeyboard());
        }

        out.println(number);
    }

    private void sendCreateRequest(PrintWriter out) {
        out.println("create");

        System.out.println("Enter player name: ");
        String name = readFromKeyboard();
        out.println(name);

        System.out.println("Enter max number: ");
        max = Integer.parseInt(readFromKeyboard());
        out.println(max);
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}