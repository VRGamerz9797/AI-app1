package com.MYai.AIapp.services;

import android.os.Handler;
import android.os.Looper;

import com.MYai.AIapp.models.AIModel;
import com.MYai.AIapp.models.ChatMessage;

// For user-added AIs, use their endpoint and key
public class GenericAIService implements AIService {
    @Override
    public String getAIName() {
        return "Generic AI";
    }

    @Override
    public void sendMessage(ChatMessage message, AIModel aiModel, AIServiceCallback callback) {
        // TODO: Replace with actual HTTP request using aiModel.getApiEndpoint() and aiModel.getApiKey()
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            callback.onSuccess(new ChatMessage(
                aiModel.getId(),
                aiModel.getName() + ": " + message.getMessage(),
                false,
                System.currentTimeMillis()
            ));
        }, 1200);
    }
}