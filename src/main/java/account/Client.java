package account;

import java.util.Random;

public class Client extends Thread {
    private Account account;

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            account.pay(new Random().nextInt(10));
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public Client(Account account) {
        this.account = account;
    }

}
