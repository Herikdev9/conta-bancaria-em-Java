import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println(("digite o saldo inicial da conta"));
        double saldoInicial = scanner.nextDouble();

        //1. instanciar a classe conta
        Conta minhaConta = new Conta(saldoInicial);

        int opcao;
        do{
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ver saldo e cheque especial disponivel");
            System.out.println("2. depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("seu saldo atual é: " + minhaConta.getSaldo());
                    System.out.println("seu cheque especial disponivel é: " + minhaConta.getChequeEspecial());
                    System.out.println("total disponivel: " + (minhaConta.getSaldo() + minhaConta.getChequeEspecial()));
                    break;
                case 2:
                    System.out.println("digite o valor para deposito:");
                    double valorDeposito = scanner.nextDouble();
                    minhaConta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("digite o valor para saque:");
                    double valorSaque = scanner.nextDouble();
                    minhaConta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("opção invalida. Tente novamente");
            }
        } while (opcao != 4);

        scanner.close();
       }
    }
