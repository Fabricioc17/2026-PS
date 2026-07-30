import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Executando a classe com os exercícios da Aula 29 ---");
    }

    public static double calcularMedia(double[] notas) {
        if (notas == null || notas.length == 0) {
            return 0.0;
        }
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static int contarAprovados(double[] notas) {
        if (notas == null) {
            return 0;
        }
        int aprovados = 0;
        for (double nota : notas) {
            if (nota >= 6.0) {
                aprovados++;
            }
        }
        return aprovados;
    }

    public static void adicionarProduto(ArrayList<String> lista, String nome) {
        if (lista != null && nome != null) {
            lista.add(nome);
        }
    }

    public static void listarProdutos(ArrayList<String> lista) {
        if (lista == null) {
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i));
        }
    }

    public static int maiorValor(int[] valores) {
        if (valores == null || valores.length == 0) {
            return 0;
        }
        int maior = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > maior) {
                maior = valores[i];
            }
        }
        return maior;
    }

    public static int maiorValor(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void exibirBoletim(double[] notas) {
        double media = calcularMedia(notas);
        int aprovados = contarAprovados(notas);
        String situacao = (media >= 6.0) ? "APROVADA" : "EM RECUPERAÇÃO";

        System.out.println("Média: " + media);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Situação: " + situacao);
    }
}
