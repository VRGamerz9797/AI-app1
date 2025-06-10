package com.MYai.AIapp.services;

import android.os.Handler;
import android.os.Looper;

import com.MYai.AIapp.models.AIModel;
import com.MYai.AIapp.models.ChatMessage;

// Replace with actual network code (Retrofit/OkHttp) for production
public class ChatGPTService implements AIService {
    @Override
    public String getAIName() {
        return "ChatGPT";
    }

    @Override
    public void sendMessage(ChatMessage message, AIModel aiModel, AIServiceCallback callback) {
        // TODO: Replace this with actual HTTP request to OpenAI endpoint
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            callback.onSuccess(new ChatMessage(
                aiModel.getId(),
                "ChatGPT: " + message.getMessage(),
                false,
                System.currentTimeMillis()
            ));
        }, 1200);
    }
}