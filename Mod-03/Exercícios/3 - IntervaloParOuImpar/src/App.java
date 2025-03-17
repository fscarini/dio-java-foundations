import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8)); // Corrige erro de acentuação no terminal
        var scanner = new Scanner(System.in);

        System.out.println("Por gentileza, digite um número inteiro: ");
        int initialNumber = scanner.nextInt();

        System.out.println("Agora, digite um número inteiro maior que o anterior: ");
        int finalNumber = scanner.nextInt();

        while (finalNumber < initialNumber) {
            System.out.println("Por gentileza, digite um número inteiro maior que o primeiro número: ");
            finalNumber = scanner.nextInt();
        }

        System.out.println("Agora, escolha em qual ordem númerica você quer imprimir o intervalo selecionado: \n1 - Par \n2 - Ímpar");
        int selector = scanner.nextInt();

        switch (selector) {
            case 1 ->  {
                for (int i = initialNumber; i < finalNumber; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            }

            case 2 ->  {
                for (int i = initialNumber; i < finalNumber; i++) {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    }
                }
            }

            default -> System.out.println("Ordem incorreta, tente novamente.");
        }

        scanner.close();

    }
}
