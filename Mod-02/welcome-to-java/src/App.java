import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner (System.in);

        System.out.println("Por gentileza, informe o seu nome");
        String name = scanner.next();

        System.out.println("Agora informe a sua idade");
        String age = scanner.next();

        System.out.printf("Olá %s, você tem %s anos de idade!", name, age);
    }
}
