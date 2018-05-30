package config;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest {
    private static final String serviceHost = "http://www.oorsprong.org";

    public void get(String specificInfo, String filename) {
        try {
            URL url = new URL(serviceHost + specificInfo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null){
                writer.append(inputLine);
            }

            writer.close();
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
