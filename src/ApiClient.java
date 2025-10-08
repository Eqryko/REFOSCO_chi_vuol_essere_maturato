import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Handler;

public class ApiClient {
    private final HttpClient client = HttpClient.newHttpClient();
    //      https://opentdb.com/api.php?amount=5&difficulty=easy&type=multiple
    public void fetchData(int amount, String difficulty, String type){
        String url = "https://opentdb.com/api.php?amount="+amount+"&difficulty="+difficulty+"&type="+type;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .header("Content-Type","application/json")
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Richiesta fallita: " + e.getMessage());
        }
        //System.out.println(response.body());

        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class); // corpo della risposta e dove devi deserializzarmelo

        if(apiResponse.response_code != 0){
            System.out.println("Errore: " + apiResponse.response_code);
            return;
        }


        for(ApiQuestion apiQuestion : apiResponse.results){
            System.out.println(apiQuestion.question);
            System.out.println(apiQuestion.correct_answer + "\n");
        }

    }
}
