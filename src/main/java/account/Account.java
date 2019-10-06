package account;

public class Account {
    private double saldo;

    public Account(double saldo) {
        this.saldo = saldo;
    }
    // metoda pobierająca kwotę z konta
    public void pay(double amount){
        if(saldo >= amount){
            saldo = saldo - amount;
            System.out.printf("%s wypłacono kwotę: %.2fzł\n",
                    Thread.currentThread().getName(),
                    amount);
        } else {
            System.out.printf("%s operacja zablokowana - brak środków\n",
                    Thread.currentThread().getName());
        }
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return "Account{" +
                "saldo=" + saldo +
                '}';
    }
}
