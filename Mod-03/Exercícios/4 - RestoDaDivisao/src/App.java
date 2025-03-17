import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8)); // Corrige erro de acentuação no terminal
        var scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int divisor = scanner.nextInt();
        float dividendo = 0;

        do {
            System.out.println("Informe outro número que seja maior que o primeiro citado: ");
            dividendo = scanner.nextFloat();

            if (dividendo <= divisor) {
                System.out.println("Informe outro número que seja maior que o primeiro citado: ");
                dividendo = scanner.nextFloat();
            } else {
                float quociente = dividendo / divisor;
                float resto = dividendo % divisor;
                System.out.println("Resultado da divisão de " + dividendo + " por " + divisor + " é igual a: " + quociente + " com resto igual a: " + resto);
            }
        } while ((dividendo % divisor) == 0);

        System.out.println("Fim da execução do programa, resto da divisão diferente de 0");
        scanner.close();

    }
}
