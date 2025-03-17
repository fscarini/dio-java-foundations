import java.util.Scanner;

public class App {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Por gentileza, digite um número inteiro para visualizar a sua tabuada:");
        int number = scanner.nextInt();
        for(int i = 1; i <= 10; i++){
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }
    }
}