package com.qa.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class MyClass<T> implements MyInterface {
    private final Class<T> responseClass;
    private static final Logger logger = Logger.getLogger(String.valueOf(MyClass.class));

    public MyClass(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;
    }

    @Override
    public void getApiResponse(final String response, File file) throws IOException, JSONException {
        final ObjectMapper mapper = new ObjectMapper();
        final T value =  mapper.readValue(file, responseClass);
        String expectedResponse = mapper.writeValueAsString(value);
        logger.info("Expected Response------>"+expectedResponse);
        final T values =  mapper.readValue(response, responseClass);
        String actualResponse = mapper.writeValueAsString(values);
        logger.info("Actual Response-------->"+actualResponse);
        Assertions.assertEquals(mapper.readTree(expectedResponse), mapper.readTree(actualResponse));
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
    }
}
