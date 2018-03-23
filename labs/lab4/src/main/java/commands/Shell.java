/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package commands;

import catalog.Catalog;
import exceptions.InvalidCommand;
import org.apache.tools.ant.types.Commandline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* The test class or client. */
public class Shell {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Catalog catalog = new Catalog();

        //Break with Ctrl+C
        while (true) {
            // read the command
            System.out.println("shell>");
            commandLine = console.readLine();

            String[] arguments = Commandline.translateCommandline(commandLine);

            if (arguments.length < 1) {
                throw new IllegalArgumentException("Wrong number of arguments.");
            }


            List <String> parameters = new LinkedList <>();
            for (int i = 1; i < arguments.length; i++) {
                parameters.add(arguments[i]);
            }

            Command command = null;

            String commandType = arguments[0];
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
                    throw new InvalidCommand(Arrays.toString(arguments));
            }

            if (command != null) {
                command.execute();
            }

        }
    }
}
