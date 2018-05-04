import game.Countdown;
import game.GuessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private final GameServer server;
    private Socket socket;

    public ClientThread(GameServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        GameServer.aliveConnections++;
        Countdown countdown = new Countdown();
        countdown.setCountDown(50);
        countdown.reset();

        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String command = "";
            command = in.readLine();
            System.out.println("Received command: " + command);

            GuessingGame game = null;
            while (!command.equals("quit")) {
                if (command.equals("create")) {
                    String name = in.readLine();
                    Integer max = Integer.parseInt(in.readLine());

                    game = new GuessingGame(name, max);
                    out.println("Welcome!!!");
                    System.out.println("Created game: " + game);
                } else if (command.equals("submit")) {
                    Integer guess = Integer.parseInt(in.readLine());
                    String result = game.submit(guess);
                    out.println(result);
                } else if (command.equals("stop")) {
                    closeSocket();
                    server.stop();
                } else {
                    out.println("The command is not valid: " + command);
                }

                if(countdown.getSecondsLeft() == 0) {
                    System.out.println("Time exceeded ... Exit");
                    closeSocket();
                }
                command = in.readLine();
                System.out.println("Received command: " + command);
            }

            out.println("Loser, the number was: " + game.getNumberToGuess());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSocket();
        }
    }


    public void closeSocket() {
        if(GameServer.aliveConnections > 0) {
            System.out.println("Close socket for connection " + GameServer.aliveConnections);
        }
        --GameServer.aliveConnections;
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}