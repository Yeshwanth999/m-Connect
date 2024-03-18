package com.adminservice.main.security;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageExtractor {

    private final ObjectMapper objectMapper;

    public MessageExtractor() {
        this.objectMapper = new ObjectMapper();
    }
    
    public String extractAdminEmailFromMessage(String jsonMessage) {
        try {
            // Parse the JSON message
            JsonNode rootNode = objectMapper.readTree(jsonMessage);
            
            // Retrieve the admin email field
            JsonNode adminEmailNode = rootNode.get("admingmail");
            if (adminEmailNode != null) {
                return adminEmailNode.asText();
            } else {
                // Admin email field not found in the JSON message
                System.err.println("Admin email field not found in the JSON message");
                return null;
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during JSON parsing
            System.err.println("Error extracting admin email from message: " + e.getMessage());
            return null;
        }
    }
}
