public class Aula31 {

    public static void main(String[] args) {
        int[] arrayInt = {8, 3, 10, 5, 12};
        double[] arrayDouble = {8.5, 3.2, 10.0, 5.7, 12.4};
        float[] arrayFloat = {8.5f, 3.2f, 10.0f, 5.7f, 12.4f};

        System.out.println("--- TESTES COM INT ---");
        System.out.println("Soma: " + calculaSoma(arrayInt));
        System.out.println("Média: " + calculaMedia(arrayInt));
        System.out.println("Menor: " + menorValor(arrayInt));
        System.out.println("Maior: " + maiorValor(arrayInt));
        System.out.println("Acima de 6: " + contarAcima(arrayInt, 6));

        System.out.println("\n--- TESTES COM DOUBLE ---");
        System.out.println("Soma: " + calculaSoma(arrayDouble));
        System.out.println("Média: " + calculaMedia(arrayDouble));
        System.out.println("Menor: " + menorValor(arrayDouble));
        System.out.println("Maior: " + maiorValor(arrayDouble));
        System.out.println("Acima de 6.0: " + contarAcima(arrayDouble, 6.0));

        System.out.println("\n--- TESTES COM FLOAT ---");
        System.out.println("Soma: " + calculaSoma(arrayFloat));
        System.out.println("Média: " + calculaMedia(arrayFloat));
        System.out.println("Menor: " + menorValor(arrayFloat));
        System.out.println("Maior: " + maiorValor(arrayFloat));
        System.out.println("Acima de 6.0f: " + contarAcima(arrayFloat, 6.0f));
    }

    public static int calculaSoma(int[] arr) {
        int soma = 0;
        for (int i = 0; i < arr.length; i++) {
            soma += arr[i];
        }
        return soma;
    }

    public static double calculaSoma(double[] arr) {
        double soma = 0;
        for (int i = 0; i < arr.length; i++) {
            soma += arr[i];
        }
        return soma;
    }

    public static float calculaSoma(float[] arr) {
        float soma = 0;
        for (int i = 0; i < arr.length; i++) {
            soma += arr[i];
        }
        return soma;
    }

    public static int calculaMedia(int[] arr) {
        if (arr.length == 0) return 0;
        return calculaSoma(arr) / arr.length; 
    }

    public static double calculaMedia(double[] arr) {
        if (arr.length == 0) return 0;
        return calculaSoma(arr) / arr.length;
    }

    public static float calculaMedia(float[] arr) {
        if (arr.length == 0) return 0;
        return calculaSoma(arr) / arr.length;
    }

    public static int menorValor(int[] arr) {
        int menor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < menor) {
                menor = arr[i];
            }
        }
        return menor;
    }

    public static double menorValor(double[] arr) {
        double menor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < menor) {
                menor = arr[i];
            }
        }
        return menor;
    }

    public static float menorValor(float[] arr) {
        float menor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < menor) {
                menor = arr[i];
            }
        }
        return menor;
    }

    public static int maiorValor(int[] arr) {
        int maior = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
            }
        }
        return maior;
    }

    public static double maiorValor(double[] arr) {
        double maior = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
            }
        }
        return maior;
    }

    public static float maiorValor(float[] arr) {
        float maior = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
            }
        }
        return maior;
    }

    public static int contarAcima(int[] arr, int limite) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > limite) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarAcima(double[] arr, double limite) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > limite) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarAcima(float[] arr, float limite) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > limite) {
                contador++;
            }
        }
        return contador;
    }
}
