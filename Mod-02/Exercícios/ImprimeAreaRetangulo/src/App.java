import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println(" ");

        System.out.println("Digite a base do retângulo:");
        var base = Integer.parseInt(scanner.next());

        System.out.println("Digite a altura do retângulo:");
        var altura = Integer.parseInt(scanner.next());

        System.out.printf("A base do retângulo é igual a = %d", (base * altura));
    }
}
