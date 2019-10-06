package account;

public class PayController {
    public static void main(String[] args) {
        Account account = new Account(20);
        Client client1 = new Client(account);
        Client client2 = new Client(account);
        Client client3 = new Client(account);

        client1.start();
        client2.start();
        client3.start();

    }
}
