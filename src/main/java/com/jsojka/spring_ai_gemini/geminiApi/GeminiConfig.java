package com.jsojka.spring_ai_gemini.geminiApi;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {
    @Value("${google.gemini.api.key}")
    private String key;

    @Value("${google.gemini.api.url}")
    private String url;

    @Bean
    public Client geminiClient() {
        return new Client();
    }
}
