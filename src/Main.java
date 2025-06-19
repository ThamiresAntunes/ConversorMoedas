
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n========== Menu para conversão de moedas ==========\n");
            System.out.println("1 - Dólar (USD) para Real (BRL)");
            System.out.println("2 - Real (BRL) para Dólar (USD)");
            System.out.println("3 - Euro (EUR) para Real (BRL)");
            System.out.println("4 - Real (BRL) para Euro (EUR)");
            System.out.println("5 -  Dólar Canadense (CAD) para Real (BRL)");
            System.out.println("6 - Real (BRL) para Dólar Canadense (CAD)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            String vInicial = "";
            String vFinal = "";
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                case 1:
                    vInicial = "USD";
                    vFinal = "BRL";
                    break;
                case 2:
                    vInicial = "BRL";
                    vFinal = "USD";
                    break;
                case 3:
                    vInicial = "EUR";
                    vFinal = "BRL";
                    break;
                case 4:
                    vInicial = "BRL";
                    vFinal = "EUR";
                    break;
                case 5:
                    vInicial = "CAD";
                    vFinal = "BRL";
                    break;
                case 6:
                    vInicial = "BRL";
                    vFinal = "CAD";
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }


        } while(opcao != 0);

        scanner.close();
    }
}
