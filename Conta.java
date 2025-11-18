public class Conta {

    private double saldo;
    private double chequeEspecial;

    // metodo construtor para inicializar o saldo e o chequeEspecial
    public Conta(double saldoinicial) {
        this.saldo = saldoinicial;
        this.chequeEspecial = 0.0;
    }


    //metodo para obter o saldo
    public double getSaldo() {
        return this.saldo;
    }

    //Metodo para obter cheque especial
    public double getChequeEspecial() {
        return this.chequeEspecial;
    }

    //metodo para depositar dinheiro e calcular o cheque especial
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            double bonusChequeEspecial = 0.0;
            if (valor <= 500) {
                bonusChequeEspecial = 50.0;
            } else {
                //Calculo simplis: 50% do valor do deposito

                bonusChequeEspecial = valor * 0.50;
            }
            this.chequeEspecial += bonusChequeEspecial;
            System.out.println("\n Deposito de " + valor + "realizado com sucesso.");
            System.out.println("parabens você ganhou um bônus de cheque especial no valor de " + bonusChequeEspecial);
            System.out.println(" seu novo limite de cheque especial é:" + this.chequeEspecial);

        } else {
            System.out.println("\n O valor do deposito deve ser positivo.");
        }

    }

    // Metodo para sacar dinheiro (usando saldo + cheque especial se necessario)
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
            return;
        }

        double valorUsadoDoCheque = 0.0;
        double valorDaTaxa = 0.0;
        double valorTotalDebitadoDoCheque = 0.0;
        double saldoTotalDisponivel = this.saldo + this.chequeEspecial;
        String mensagem = "";

        // 1. Verificar se o valor é maior que o saldo (haverá uso do cheque especial)
        if (valor > this.saldo) {
            valorUsadoDoCheque = valor - this.saldo;
            valorDaTaxa = valorUsadoDoCheque * 0.20; // 20% de taxa
            valorTotalDebitadoDoCheque = valorUsadoDoCheque + valorDaTaxa;

            // Verificar se há limite suficiente no cheque especial para o valor + taxa
            if (valorTotalDebitadoDoCheque <= this.chequeEspecial) {
                // Se sim, o saque é possível. Zera o saldo e debita do cheque.
                this.saldo = 0;
                this.chequeEspecial -= valorTotalDebitadoDoCheque;
                mensagem = "\nSaque de " + valor + " realizado com sucesso (uso de cheque especial cobrado taxa de 20%).";
            } else {
                // Se não, o saque é impossível.
                System.out.println("\nSaldo e cheque especial insuficientes para cobrir o valor + taxas.");
                System.out.println("Disponivel total (sem taxas): " + saldoTotalDisponivel);
                return; // Encerra o método aqui
            }
        } else {
            // 2. O valor é menor ou igual ao saldo (sem uso do cheque especial)
            this.saldo -= valor;
            mensagem = "\nSaque de " + valor + " realizado com sucesso (uso apenas do saldo).";
        }

        // Imprime o resultado final após um saque bem-sucedido
        System.out.println(mensagem);
        System.out.println("Saldo restante: " + this.saldo);
        System.out.println("Limite de cheque especial restante: " + this.chequeEspecial);
    }

}





