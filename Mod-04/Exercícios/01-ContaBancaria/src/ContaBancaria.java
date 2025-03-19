public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;
    private double saldoChequeEspecial = saldo + chequeEspecial;

    public ContaBancaria(){}

    public void depositar(double saldo) {
        this.saldo += saldo;
    }

    public void sacar(double saldo) {
        this.saldo -= saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void acrescentaChequeEspecial(double chequeEspecial){
        this.chequeEspecial += chequeEspecial;
    }

    public double getSaldoChequeEspecial() {
        return saldoChequeEspecial;
    }

    public void setSaldoChequeEspecial(){
        this.saldoChequeEspecial = this.saldo + this.chequeEspecial;
    }

}
