package com.appverse.service;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
import java.util.HashMap;
import java.util.Map;
 
@Service
public class ChatService {
 
    @Value("${openai.api.key}")
    private String apiKey;
 
    public String askChatGPT(String prompt) {
    	
    	System.out.println(System.getProperty("java.version"));
    	System.out.println(System.getProperty("java.home"));
    	
    	RestTemplate restTemplate=new RestTemplate();
    	 
        try {
     
            java.net.http.HttpClient client =
                    java.net.http.HttpClient.newHttpClient();
     
            String body = """
            {
              "model":"gpt-4o-mini",
              "messages":[
                {
                  "role":"user",
                  "content":"%s"
                }
              ]
            }
            """.formatted(prompt.replace("\"", "\\\""));
     
            java.net.http.HttpRequest request =
                    java.net.http.HttpRequest.newBuilder()
                            .uri(java.net.URI.create("https://api.openai.com/v1/chat/completions"))
                            .header("Authorization", "Bearer " + apiKey)
                            .header("Content-Type", "application/json")
                            .POST(java.net.http.HttpRequest.BodyPublishers.ofString(body))
                            .build();
     
            java.net.http.HttpResponse<String> response =
                    client.send(request,
                            java.net.http.HttpResponse.BodyHandlers.ofString());
     
            return response.body();
     
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
     
     
}
 