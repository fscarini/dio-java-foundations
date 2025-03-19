
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por gentileza, digite o seu nome para cadastro da sua conta bancária: ");
        String name = scanner.next();

        System.out.println("Por gentileza, digite um valor de depósito incial para o seu saldo: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria();
        conta.setSaldo(saldoInicial);
        if (saldoInicial <= 500) {
            conta.setChequeEspecial(50);
        } else {
            conta.setChequeEspecial(saldoInicial * 0.5);
        }
        conta.setSaldoChequeEspecial();
        double saldoInicialChequeEspecial = conta.getChequeEspecial();

        while (true) {
            System.out.println("Olá, " + name + "! Bem-vindo ao Bando do Mula! Qual operação deseja realizar hoje? \n1 - Consultar Saldo \n2 - Consultar Cheque Especial \n3 - Depositar Dinheiro \n4 - Sacar Dinheiro \n5 - Pagar um Boleto \n6 - Minha conta está usando cheque especial? \n7 - Sair");
            int seletor = scanner.nextInt();

            switch (seletor) {
                case 1: {
                    double saldoAtual = conta.getSaldo();
                    System.out.println("Seu saldo atual é de: R$" + saldoAtual);
                    waitForKeyPress();
                    break;
                }

                case 2: {
                    double chequeEspecialAtual = conta.getChequeEspecial();
                    System.out.println("Seu cheque especial atual é de: R$" + chequeEspecialAtual + "\n");
                    waitForKeyPress();
                    break;
                }

                case 3: {
                    System.out.println("Por gentileza, digite um valor para depositar: ");
                    double deposito = scanner.nextDouble();
                    if (saldoInicialChequeEspecial < conta.getChequeEspecial()) {
                        System.out.println("Será descontado 20% do valor do depósito e realocado para o cheque espeicla pelo uso do mesmo.");
                        conta.acrescentaChequeEspecial(deposito * 0.2);
                        deposito = deposito * 0.2;
                        conta.depositar(deposito);
                        conta.setSaldoChequeEspecial();
                        System.out.println("Você depositou um total de: R$" + deposito + "\n");
                        waitForKeyPress();
                    } else {
                        conta.depositar(deposito);
                        conta.acrescentaChequeEspecial(deposito * 0.4);
                        conta.setSaldoChequeEspecial();
                        System.out.println("Você depositou um total de: R$" + deposito + "\n");
                        waitForKeyPress();
                    }
                    break;
                }

                case 4: {
                    System.out.println("Por gentileza, digite um valor para saque: ");
                    double saque = scanner.nextDouble();

                    while (saque > conta.getSaldo()) {
                        System.out.println("Por gentileza, digite um valor válido para o saque: ");
                        saque = scanner.nextDouble();
                    }
                    conta.sacar(saque);
                    conta.setSaldoChequeEspecial();
                    System.out.println("Você sacou um total de: R$" + saque + "\n");
                    waitForKeyPress();
                    break;
                }

                case 5: {
                    System.out.println("Por gentileza, digite a linha digitável do boleto: ");
                    var linhaDigitavel = scanner.next();
                    System.out.println("Agora, digite o valor do boleto: ");
                    double valorBoleto = scanner.nextDouble();

                    if (valorBoleto > conta.getSaldo()) {
                        System.out.println("Saldo insuficiente. ");
                        if (conta.getSaldoChequeEspecial() >= valorBoleto) {
                            System.out.println("Cheque especial disponível, deseja utilizar? (Y/N) ");
                            System.out.println("OBS: Caso o aceite seja feito, será cobrada uma taxa de 20% no seu próximo depósito");
                            String confirmaUsoChequeEspecial = scanner.next();

                            switch (confirmaUsoChequeEspecial) {
                                case "Y", "y": {
                                    double saldoAtual = conta.getSaldo();
                                    double chequeEspecial = conta.getChequeEspecial();
                                    double restoBoleto = saldoAtual - valorBoleto;
                                    conta.setSaldo(0 + restoBoleto);
                                    restoBoleto = chequeEspecial - -(restoBoleto);
                                    conta.setChequeEspecial(restoBoleto);
                                    conta.setSaldoChequeEspecial();
                                    System.out.println("O valor de R$" + valorBoleto + " foi pago utilizando seu cheque especial. \nBoleto nº " + linhaDigitavel);
                                    waitForKeyPress();
                                    break;
                                }

                                case "N", "n": {
                                    System.out.println("O valor de R$" + valorBoleto + " naõ foi pago devido ao saldo insuficiente");
                                    waitForKeyPress();
                                    break;
                                }

                                default: {
                                    System.out.println("Opção inválida");
                                    waitForKeyPress();
                                    break;
                                }
                            }
                        }
                    } else {
                        conta.sacar(valorBoleto);
                        conta.setSaldoChequeEspecial();
                    }
                    System.out.println("O valor de R$" + valorBoleto + " foi pago. \nBoleto nº " + linhaDigitavel);
                    waitForKeyPress();
                    break;
                }

                case 6: {
                    if (saldoInicialChequeEspecial < conta.getChequeEspecial()) {
                        System.out.println("Você está utilizando o cheque especial da sua conta.");
                    } else {
                        System.out.println("Você não está utilizando o cheque especial da sua conta.");
                    }
                    break;
                }

                case 7: {
                    System.out.println("Obrigado por usar o Banco do Mula, até logo!");
                    scanner.close();
                    return;
                }

                default:
                    System.out.println("Opção inválida, tente novamente.");

            }
        }

    }

    public static void waitForKeyPress() {
        System.out.println("Pressione qualquer tecla para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
