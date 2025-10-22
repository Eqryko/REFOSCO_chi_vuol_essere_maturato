import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*ApiClient api = new ApiClient();
        System.out.println(api.fetchQuestions(5, "easy", "multiple"));
*/
        System.out.println("CHI VUOLE ESSERE MATURATO?");
        Scanner scanner = new Scanner(System.in);

        ApiClient client = new ApiClient();

        System.out.print("Inserisci nome: ");
        String playerName = scanner.nextLine();



        int correctAnswers = 0;
        boolean used5050 = false;
        boolean usedAudience = false;

        PlayerStatistics stats = new PlayerStatistics(
          playerName,
          correctAnswers,
          used5050,
          usedAudience
        );

        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(playerName + "_stats.json")) {
            gson.toJson(stats, writer);
            System.out.println("Statistiche salvate correttamente in " + playerName + "_stats.json");
        } catch (IOException e){
            System.out.println("Errore durante il salvataggio delle statistiche: " + e.getMessage());
        }

/*
        System.out.print("Inserisci il numero di domande da prendere: ");
        int amount = scanner.nextInt();

        System.out.print("\n");
        client.fetchData(amount, "easy","multiple");
*/
        client.fetchData(5, "easy","multiple");
        client.fetchData(3, "medium","multiple");
        client.fetchData(2, "hard","multiple");

    }
}