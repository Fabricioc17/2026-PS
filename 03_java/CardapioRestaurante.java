import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     RESTAURANTE DA COPA         ");
        System.out.println("=================================");
        System.out.println("     CARDÁPIO ELETRÔNICO");
        System.out.println("=================================");
        System.out.println("1 - X-Burguer .......... R$ 18,00");
        System.out.println("2 - Pizza .............. R$ 35,00");
        System.out.println("3 - Suco Natural ....... R$ 8,00");
        System.out.println("4 - Café ............... R$ 5,00");
        System.out.println("5 - Jujuba ............... R$ 6,00");
        System.out.println("6 - Bolo ............... R$ 17,00");
        System.out.println("=================================");

        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();

        if (opcao == 1) {
            System.out.println("Você escolheu X-Burguer.");
            System.out.println("R$ 18,00");
        } else if (opcao == 2) {
            System.out.println("Você escolheu Pizza.");
            System.out.println("R$ 35,00");
        } else if (opcao == 3) {
             System.out.println("Você escolheu Suco Natural.");
             System.out.println("R$ 8,00");
        } else if (opcao == 4) {
            System.out.println("Você escolheu Café.");
            System.out.println("R$ 5,00");
        } else if (opcao == 5) {
            System.out.println("Você escolheu Jujuba.");
            System.out.println("R$ 6,00");
        } else if (opcao == 6) {
            System.out.println("Você escolheu Bolo.");
            System.out.println("R$ 17,00");
        } else {
            System.out.println("A Opção não está inclusa no cardápio...");
        }

        entrada.close();
    }
}