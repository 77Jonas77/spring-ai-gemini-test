package com.jsojka.spring_ai_gemini.geminiApi;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.GenerateContentResponseUsageMetadata;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    private final Client client;

    public GeminiService(Client client) {
        this.client = client;
    }

    public String generateContent(String prompt) {
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash",
                prompt,
                null
        );

        System.out.println(response.text());
        System.out.println("=====");
        System.out.println(response.usageMetadata().flatMap(GenerateContentResponseUsageMetadata::totalTokenCount));
        System.out.println("=====");
        System.out.println(response.usageMetadata().flatMap(GenerateContentResponseUsageMetadata::promptTokenCount));

        return response.text();
    }
}
