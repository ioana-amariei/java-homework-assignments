/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package commands;

import catalog.Catalog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* The test class or client. */
public class Shell {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        //Break with Ctrl+C
        while(true) {
            // read the command
            System.out.println("shell>");
            commandLine = console.readLine();

            List<String> tokens = new LinkedList <>();
            StringTokenizer stringTokenizer = new StringTokenizer(commandLine, "\"");
            while (stringTokenizer.hasMoreTokens()) {
                System.out.println(stringTokenizer.nextToken());
                tokens.add(stringTokenizer.nextToken());
            }

            if (tokens.size() < 2) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }

            Catalog catalog = new Catalog();

            List <String> parameters = new LinkedList <>();
            for (int i = 1; i < tokens.size(); i++) {
                parameters.add(tokens.get(i));
            }

            Command command = null;

            String commandType = tokens.get(0);
            switch (commandType) {
                case "add":
                    command = new AddCommand(catalog, parameters);
                    break;
                case "list":
                    command = new ListCommand(catalog);
                    break;
                case "load":
                    command = new LoadCommand(parameters);
                    break;
                case "play":
                    command = new PlayCommand(catalog, parameters);
                    break;
                case "save":
                    command = new SaveCommand(catalog, parameters);
                    break;
                case "exit":
                    System.out.println("Exiting shell...");
                    System.exit(0);
                    break;
                case "report":
                    command = new ReportCommand(catalog, parameters);
                    break;
                default:
                    System.out.println("The command is not valid.");
            }

            if (command != null) {
                command.execute();
                command = null;
            }

        }
    }
}
