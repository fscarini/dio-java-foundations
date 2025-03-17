import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Garante que o separador do valor passado para o scanner seja feito com o .

        System.out.printf("Por gentileza, digite o seu peso (kg): ");
        double peso = scanner.nextDouble();
        System.out.println(""); // Pula linha

        System.out.printf("Por gentileza, digite a sua altura (m): ");
        double altura = scanner.nextDouble();
        System.out.println(""); // Pula linha

        double imc = peso / (altura * altura);
        String imcArredondado = String.format("%.2f", imc);

        if (imc <= 18.5) {
            System.out.println("Valor do IMC: " + imcArredondado + " - Abaixo do peso");
        } else if (imc <= 24.9) { 
            System.out.println("Valor do IMC: " + imcArredondado + " - Peso ideal");
        } else if (imc <= 29.9) { 
            System.out.println("Valor do IMC: " + imcArredondado + " - Levemente acima do peso");
        } else if (imc <= 34.9) { 
            System.out.println("Valor do IMC: " + imcArredondado + " - Obesidade Grau I");
        } else if (imc <= 39.9) { 
            System.out.println("Valor do IMC: " + imcArredondado + " - Obesidade Grau II (Severa)");
        } else {
            System.out.println("Valor do IMC: " + imcArredondado + " - Obesidade Grau III (Mórbida)");
        }

    }
}
