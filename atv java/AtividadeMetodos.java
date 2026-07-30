public class AtividadeMetodos {

    public static void main(String[] args) {
        System.out.println("--- Problema 1: Calculadora de Desconto ---");
        System.out.println("Resultado: " + calcularDesconto(100, 10)); // Esperado: 90.0
        System.out.println("Resultado: " + calcularDesconto(250, 20)); // Esperado: 200.0
        System.out.println("Resultado: " + calcularDesconto(500, 15)); // Esperado: 425.0
        System.out.println();

        System.out.println("--- Problema 2: Verificador de Maior Valor ---");
        System.out.println("Resultado: " + maiorNumero(10, 20)); // Esperado: 20
        System.out.println("Resultado: " + maiorNumero(50, 5));  // Esperado: 50
        System.out.println("Resultado: " + maiorNumero(30, 30)); // Esperado: 30
        System.out.println();

        System.out.println("--- Problema 3: Sistema de Frete ---");
        System.out.println("Resultado: R$ " + calcularFrete(0.5)); // Esperado: 10.0
        System.out.println("Resultado: R$ " + calcularFrete(3));   // Esperado: 20.0
        System.out.println("Resultado: R$ " + calcularFrete(8));   // Esperado: 35.0
        System.out.println();

        System.out.println("--- Problema 4: Sobrecarga de Soma ---");
        System.out.println("Resultado int: " + somar(5, 3));       // Esperado: 8
        System.out.println("Resultado double: " + somar(2.5, 3.5)); // Esperado: 6.0
        System.out.println("Resultado int: " + somar(100, 50));    // Esperado: 150
        System.out.println();

        // --- Testes do Problema 5 ---
        System.out.println("--- Problema 5: Sistema de Cardápio ---");
        exibirProduto("Refrigerante");
        exibirProduto("Pizza", 39.90);
        exibirProduto("Hambúrguer", 22.50);
    }

    public static double calcularDesconto(double valor, double percentual) {
        return valor - (valor * (percentual / 100));
    }

    public static int maiorNumero(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static double calcularFrete(double peso) {
        if (peso <= 1.0) {
            return 10.0;
        } else if (peso <= 5.0) {
            return 20.0;
        } else {
            return 35.0;
        }
    }

    public static int somar(int a, int b) {
        return a + b;
    }

    public static double somar(double a, double b) {
        return a + b;
    }

    public static void exibirProduto(String nome) {
        System.out.println("Produto: " + nome);
    }

    public static void exibirProduto(String nome, double preco) {
        System.out.println("Produto: " + nome);
        System.out.printf("Preço: R$ %.2f\n", preco);
    }
}
