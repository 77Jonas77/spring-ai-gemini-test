package com.jsojka.spring_ai_gemini.geminiApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {
    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateText(@RequestBody GenerateTextRequest request) {
        String prompt = "Generate a blog outline on the topic: " + request.text();
        String response = String.valueOf(geminiService.generateContent(prompt));

        return ResponseEntity.ok(response);
    }
}
