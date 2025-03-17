import java.util.Scanner;

public class App {
    public static void main(String[] args){
        @SuppressWarnings("resource")
        var scanner = new Scanner(System.in);
        System.out.println(" ");

        System.out.println("Por gentileza, digite o nome da primeira pessoa:");
        String firstPersonName = scanner.next();
        System.out.println("Agora, a idade da primeira pessoa:");
        var firstPersonAge = Integer.parseInt(scanner.next());

        System.out.println("Por gentileza, digite o nome da segunda pessoa:");
        String secondPersonName = scanner.next();
        System.out.println("Agora, a idade da segunda pessoa:");
        var secondPersonAge = Integer.parseInt(scanner.next());

        int ageDiference = firstPersonAge - secondPersonAge;
        if(ageDiference < 0){
            ageDiference = (-(ageDiference));
        }

        System.out.printf("A diferença de idade entre %s e %s é de %d ano(s)", firstPersonName, secondPersonName, ageDiference);
    }
}
