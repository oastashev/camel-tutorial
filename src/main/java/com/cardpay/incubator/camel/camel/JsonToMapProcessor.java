package com.cardpay.incubator.camel.camel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class JsonToMapProcessor {

    private static final TypeReference MAP_TYPE_REF = new TypeReference<Map<String, Object>>() {
    };

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Handler
    public Map<String, String> process(@Body String body) throws IOException {
        return OBJECT_MAPPER.readValue(body, MAP_TYPE_REF);
    }

}
