package app;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.*;

public class LocaleExplorer {
    private final String baseName = "Messages";
    private Locale locale;
    private ResourceBundle resourceBundle;

    public static void main(String args[]) {
        new LocaleExplorer().run();
    }

    public void run() {
        setLocale("en-US");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales":
                    displayLocales();
                    break;
                case "set":
                    setLocale(params[1]);
                    break;
                case "info":
                    localeInfo();
                    break;
                default:
                    System.out.println(message("invalid"));
            }
        }
    }

    private String message(String key, String... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }

    private void setLocale(String languageTag) {
        this.locale = Locale.forLanguageTag(languageTag);
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        message("locale.set", languageTag);
    }

    private void displayLocales() {
        message("locales");

        JFrame frame = new JFrame("Available Locales Info");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Locale locale : locale.getAvailableLocales()) {
            textArea.append(infoFor(locale) + "\n");
        }

        createAndShowGUI(textArea, frame);
    }

    private void localeInfo() {
        message("locale.set");

        JFrame frame = new JFrame("Current Locale Info");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        textArea.append(infoFor(locale));

        createAndShowGUI(textArea, frame);
    }

    private String infoFor(Locale locale) {
        StringBuilder localeInfo = new StringBuilder();

        try {
            localeInfo.append("Country: " + locale.getDisplayCountry() + "\n");
            localeInfo.append("Language: " + locale.getDisplayLanguage() + "\n");
            localeInfo.append("Currency: " + Currency.getInstance(locale).getDisplayName() + "\n");
            localeInfo.append("Week Days: " + Arrays.toString(DateFormatSymbols.getInstance(locale).getWeekdays()) + "\n");
            localeInfo.append("Months: " + Arrays.toString(DateFormatSymbols.getInstance(locale).getMonths()) + "\n");
            localeInfo.append("Today: " + DateFormat.getDateInstance(DateFormat.LONG, locale).format(new Date()) + "\n");
        } catch (Exception e) {
            localeInfo.append("More info could not be provided for this locale.");
        }

        return localeInfo.toString();
    }

    private static void createAndShowGUI(JTextArea textArea, JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setFont(new Font("Arial",Font.BOLD, 16));

        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }
}
