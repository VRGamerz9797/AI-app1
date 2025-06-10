package com.MYai.AIapp.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.MYai.AIapp.models.AIModel;
import com.MYai.AIapp.models.ChatMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class AIRepository {
    private static final String PREFS_NAME = "AIAppPrefs";
    private static final String AI_LIST_KEY = "AIs";
    private static final String CHAT_HISTORY_KEY_PREFIX = "ChatHistory_";
    private SharedPreferences prefs;
    private Gson gson = new Gson();

    public AIRepository(Context context) {
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public List<AIModel> getAllAIs() {
        String json = prefs.getString(AI_LIST_KEY, null);
        if (json == null) {
            List<AIModel> list = new ArrayList<>();
            list.add(new AIModel("ChatGPT", "https://api.openai.com/v1/chat/completions", ""));
            return list;
        }
        return gson.fromJson(json, new TypeToken<List<AIModel>>(){}.getType());
    }

    public void addAI(AIModel ai) {
        List<AIModel> list = getAllAIs();
        list.add(ai);
        prefs.edit().putString(AI_LIST_KEY, gson.toJson(list)).apply();
    }

    public void removeAI(String id) {
        List<AIModel> list = getAllAIs();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                break;
            }
        }
        prefs.edit().putString(AI_LIST_KEY, gson.toJson(list)).apply();
    }

    public List<ChatMessage> getChatHistory(String aiId) {
        String json = prefs.getString(CHAT_HISTORY_KEY_PREFIX + aiId, null);
        if (json == null) return new ArrayList<>();
        return gson.fromJson(json, new TypeToken<List<ChatMessage>>(){}.getType());
    }

    public void addChatMessage(ChatMessage message) {
        List<ChatMessage> history = getChatHistory(message.getAiId());
        history.add(message);
        prefs.edit().putString(CHAT_HISTORY_KEY_PREFIX + message.getAiId(), gson.toJson(history)).apply();
    }
}