package commands;

import catalog.Catalog;
import documents.Document;
import exceptions.InvalidReportCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ReportCommand implements Command {
    private Catalog catalog;
    private String reportedDocumentType;
    private String path;

    public ReportCommand(Catalog catalog, List <String> parameters) {
        String command = "report" + parameters;

        if(parameters.size() != 2){
            throw new InvalidReportCommand(command);
        }

        if(parameters.get(0).compareTo("html") != 0){
            throw new IllegalArgumentException("Argument is invalid.");
        }

        this.catalog = catalog;
        this.reportedDocumentType = parameters.get(0);
        this.path = parameters.get(1);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        List<Document> documents = new LinkedList <>(this.catalog.getDocuments());

        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            " <title>Catalog Report</title>" +
                            "<style>\n" +
                            "table, th, td {\n" +
                            "    border: 1px solid black;\n" +
                            "}\n" +
                            "</style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "<table>\n" +
                            "<th>Title</th>" +
                            "<th>Path</th><th>Year</th><th>Authors</th>");

        for(Document document : documents){
            htmlBuilder.append("<tr>\n" +
                    "    <td>" +  document.getTitle() + "</td>\n" +
                    "    <td>" + document.getPath() + "</td>\n" +
                    "    <td>" + document.getYear() + "</td>\n" +
                    "    <td>" + document.getAuthors() + "</td>\n" +
                    "  </tr>");
        }

        htmlBuilder.append("</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

        try (PrintWriter outputFile = new PrintWriter(path)) {
            outputFile.println(htmlBuilder.toString());
            outputFile.flush();
        }
    }
}
