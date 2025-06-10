package com.MYai.AIapp.models;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    private String aiId;
    private String message;
    private boolean isUser;
    private long timestamp;

    public ChatMessage(String aiId, String message, boolean isUser, long timestamp) {
        this.aiId = aiId;
        this.message = message;
        this.isUser = isUser;
        this.timestamp = timestamp;
    }

    public String getAiId() { return aiId; }
    public String getMessage() { return message; }
    public boolean isUser() { return isUser; }
    public long getTimestamp() { return timestamp; }
}