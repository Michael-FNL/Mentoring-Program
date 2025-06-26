package api.model.mapper;

import api.model.dtos.LaunchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LaunchMapper {
    private final ObjectMapper objectMapper;

    public LaunchMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public LaunchResponse fromJson(String json) {
        try {
            return objectMapper.readValue(json, LaunchResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize LaunchResponse: " + e.getMessage(), e);
        }
    }
}
