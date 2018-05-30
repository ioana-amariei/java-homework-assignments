package controller;

import config.GetRequest;

public class ContinentController {
    private String allContinentsByName = "/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName/JSON/debug";
    private GetRequest getRequest;

    public ContinentController(GetRequest getRequest) {
        this.getRequest = getRequest;
    }

    public void saveContinents() {
        getRequest.get(allContinentsByName, "continents.json");
    }
}
