import java.util.Random;
import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        // Definição dos nomes e preços dos produtos baseados no menu do IFPR
        String[] produtos = {"X-Burguer", "Pizza", "Batata Frita", "Refrigerante", "Sorvete"};
        double[] precos = {18.00, 35.00, 12.00, 8.00, 7.00};
        
        // Vetor para armazenar as quantidades pedidas de cada item (índice 0 a 4)
        int[] quantidadesPedidas = new int[5];
        
        int continuar = 1;

        // Loop principal da compra
        while (continuar == 1) {
            System.out.println("===========================");
            System.out.println("       Pizza Planet     ");
            System.out.println("===========================");
            System.out.println("1 - Pizza De Queijo ");
            System.out.println("2 - Refrigerante");
            System.out.println("3 - Sorvete do buzz Lightyear");
            System.out.println("4 - Woody Boneco");
            System.out.println("5 - ");
            System.out.println("6 - Finalizar Pedido");
            System.out.println("===========================");
            
            System.out.print("Escolha: ");
            int escolha = entrada.nextInt();

            // Validação da opção de finalizar direto no menu principal
            if (escolha == 6) {
                break;
            }

            // Validação de opções incorretas
            if (escolha < 1 || escolha > 5) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = entrada.nextInt();
            
            if (qtd > 0) {
                // Adiciona a quantidade ao produto correspondente (ajustando o índice de 1-5 para 0-4)
                quantidadesPedidas[escolha - 1] += qtd;
                System.out.println("\nItem adicionado ao pedido!");
            } else {
                System.out.println("Quantidade inválida.");
                continue;
            }

            // Menu de continuação de compra
            System.out.println("\nDeseja continuar comprando?");
            System.out.println("1 - Sim");
            System.out.println("2 - Finalizar");
            System.out.print("Escolha: ");
            continuar = entrada.nextInt();
            System.out.println();
        }

        // Exibição do resumo do pedido
        System.out.println("===========================");
        System.out.println("     RESUMO DO PEDIDO      ");
        System.out.println("===========================");

        double totalGeral = 0;
        boolean temItens = false;

        // Varre a lista de produtos para calcular e exibir apenas o que foi comprado
        for (int i = 0; i < quantidadesPedidas.length; i++) {
            if (quantidadesPedidas[i] > 0) {
                double subtotal = quantidadesPedidas[i] * precos[i];
                totalGeral += subtotal;
                temItens = true;
                // CORRIGIDO: Alterado de System.text.printf para System.out.printf
                System.out.printf("%dx %-15s ..... R$ %.2f\n", quantidadesPedidas[i], produtos[i], subtotal);
            }
        }

        if (!temItens) {
            System.out.println("Nenhum item foi adicionado.");
        }

        System.out.printf("\nTOTAL: R$ %.2f\n", totalGeral);
        System.out.println("===========================");

        // Processamento do pagamento se houver consumo
        if (totalGeral > 0) {
            System.out.println("Forma de pagamento:\n");
            System.out.println("1 - Dinheiro");
            System.out.println("2 - Cartão");
            System.out.println("3 - PIX");
            System.out.print("\nEscolha: ");
            int pagamento = entrada.nextInt();

            System.out.println("\nPagamento realizado com sucesso!");
            
            // Gera um número aleatório de pedido entre 100 e 999
            int numeroPedido = random.nextInt(900) + 100;
            System.out.println("\nPedido Nº " + numeroPedido);
            System.out.println("\nAguarde a chamada do seu pedido.");
        }

        entrada.close();
    }
}
