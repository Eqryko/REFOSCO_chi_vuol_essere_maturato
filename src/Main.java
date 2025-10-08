import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*ApiClient api = new ApiClient();
        System.out.println(api.fetchQuestions(5, "easy", "multiple"));
*/
        Scanner scanner = new Scanner(System.in);

        ApiClient client = new ApiClient();
        System.out.print("Inserisci il numero di domande da prendere: ");
        int amount = scanner.nextInt();

        System.out.print("\n");
        client.fetchData(amount, "easy","multiple");


    }
}