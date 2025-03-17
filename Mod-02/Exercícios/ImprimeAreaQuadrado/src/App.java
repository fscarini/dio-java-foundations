import java.util.Scanner;

public class App {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho do lado do quadrado");
        var lado = Integer.parseInt(scanner.next());

        System.out.printf("O valor da área do quadrado é igual a = %d", (lado * lado));
    }
}
