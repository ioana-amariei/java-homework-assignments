package view;

import config.GetRequest;
import controller.ContinentController;
import deserializer.JsonDeserializer;
import model.Continent;

import java.io.IOException;
import java.util.List;

public class ContinentView {
    private static JsonDeserializer jsonDeserializer = new JsonDeserializer();
    private static GetRequest getRequest = new GetRequest();
    private static ContinentController continentController = new ContinentController(getRequest);

    public void displayAllContinents() throws IOException {
        continentController.saveContinents();
        List <Continent> continents = jsonDeserializer.continents();

        for (Continent continent : continents) {
            System.out.println(continent);
            System.out.println(' ');
        }
    }

}
