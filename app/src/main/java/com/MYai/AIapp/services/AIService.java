package com.MYai.AIapp.services;

import com.MYai.AIapp.models.AIModel;
import com.MYai.AIapp.models.ChatMessage;

public interface AIService {
    String getAIName();
    void sendMessage(ChatMessage message, AIModel aiModel, AIServiceCallback callback);

    interface AIServiceCallback {
        void onSuccess(ChatMessage reply);
        void onError(Exception e);
    }
}