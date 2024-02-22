import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a Criptomoeda que você deseja ver a cotação: ");
        String cripto = scanner.nextLine().toLowerCase().trim();

        String baseUrl = "https://api.coingecko.com/api/v3/simple/price?ids="+ cripto +"&vs_currencies=BRL";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri( URI.create(baseUrl))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}