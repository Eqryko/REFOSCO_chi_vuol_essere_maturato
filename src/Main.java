import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*ApiClient api = new ApiClient();
        System.out.println(api.fetchQuestions(5, "easy", "multiple"));
*/
        Scanner scanner = new Scanner(System.in);

        ApiClient client = new ApiClient();

        System.out.print("Inserisci nome: ");
        String playerName = scanner.nextLine();


        System.out.print("Inserisci il numero di domande da prendere: ");
        int amount = scanner.nextInt();

        System.out.print("\n");
        client.fetchData(amount, "easy","multiple");



        int correctAnswers = 0;
        boolean used5050 = false;
        boolean usedAudience = false;

        PlayerStatistics stats = new PlayerStatistics(
          playerName,
          correctAnswers,
          used5050,
          usedAudience
        );

    }
}