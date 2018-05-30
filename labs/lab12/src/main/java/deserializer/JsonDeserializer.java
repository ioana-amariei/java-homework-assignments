package deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Continent;
import model.Country;
import model.Currency;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDeserializer {
    ObjectMapper mapper = new ObjectMapper();

    public List <Country> countries() throws IOException {
        return mapper.readValue(new File("countries.json"), new TypeReference <List <Country>>() {});
    }

    public Country country() throws IOException {
        return mapper.readValue(new File("countryByCode.json"), Country.class);
    }

    public Currency currency() throws IOException {
        return mapper.readValue(new File("currencyByCode.json"), Currency.class);
    }

    public List<Continent> continents() throws IOException {
        return mapper.readValue(new File("continents.json"), new TypeReference <List <Continent>>() {});
    }
}
