package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

public class CambioService {
    private final String API_KEY;

    public CambioService() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config"));
            API_KEY = props.getProperty("API_KEY");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar config: " + e.getMessage());
        }
    }


    public double buscarTaxaCambio(String vInicial, String vFinal) {
        String urlStr = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, vInicial);

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
            conexao.setRequestMethod("GET");
            Scanner leitor = new Scanner(conexao.getInputStream());
            StringBuilder resposta = new StringBuilder();

            while(leitor.hasNext()) {
                resposta.append(leitor.nextLine());
            }

            leitor.close();
            JsonObject json = JsonParser.parseString(resposta.toString()).getAsJsonObject();
            System.out.println("Resposta JSON: " + String.valueOf(resposta));
            JsonObject rates = json.getAsJsonObject("conversion_rates");
            System.out.println("Moeda destino esperada: " + vFinal);
            System.out.println("Chaves disponíveis: " + String.valueOf(rates.keySet()));
            if (rates != null && rates.has(vFinal)) {
                System.out.println("Entrou if do rates");
                System.out.println("vFinal: " + vFinal);
                return rates.get(vFinal).getAsDouble();
            } else {
                System.out.println("Moeda destino não encontrada na resposta.");
                return 1.0;
            }
        } catch (IOException var10) {
            IOException e = var10;
            System.out.println("Erro ao buscar taxa de câmbio: " + e.getMessage());
            return 1.0;
        }
    }
}
