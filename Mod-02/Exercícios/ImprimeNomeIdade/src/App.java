import java.util.Scanner;

public class App {
    public static void main(String[] args){
        System.out.println("Olá, seja bem-vindo ao exercício básico do segundo módulo de Java");
        System.out.println("================================================================");

        var scanner = new Scanner(System.in);

        System.out.println("Por gentileza, digite o seu nome:");
        String name = scanner.next();

        System.out.println("Agora, digite o ano do seu nascimento");
        String year = scanner.next();
        int age = 2025 - Integer.parseInt(year);

        System.out.printf("Olá, %s! Você tem %s anos de idade.", name, age);


    }
}
