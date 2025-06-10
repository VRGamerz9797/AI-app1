package com.MYai.AIapp.models;

import java.io.Serializable;
import java.util.UUID;

public class AIModel implements Serializable {
    private String id;
    private String name;
    private String apiEndpoint;
    private String apiKey;

    public AIModel(String name, String apiEndpoint, String apiKey) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.apiEndpoint = apiEndpoint;
        this.apiKey = apiKey;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getApiEndpoint() { return apiEndpoint; }
    public String getApiKey() { return apiKey; }

    public void setName(String name) { this.name = name; }
    public void setApiEndpoint(String apiEndpoint) { this.apiEndpoint = apiEndpoint; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
}