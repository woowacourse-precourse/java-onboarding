package onboarding.solution5;

import java.util.ArrayList;
import java.util.List;

public class ChangeMoney {
    private static List<Integer> emptyWallet(){
        List <Integer> wallet = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++){
            wallet.add(0);
        }
        return wallet;
    }

    public static List<Integer> changeMoney(int money){
        List <Integer> wallet = emptyWallet();
        if (money >= 50000){
            wallet.set(0, money/50000);
            money %= 50000;
        }
        if (money >= 10000){
            wallet.set(1, money/10000);
            money %= 10000;
        }
        if (money >= 5000){
            wallet.set(2, money / 5000);
            money %= 5000;
        }
        if (money >= 1000){
            wallet.set(3, money / 1000);
            money %= 1000;
        }
        if (money >= 500) {
            wallet.set(4, money / 500);
            money %= 500;
        }
        if (money >= 100) {
            wallet.set(5, money / 100);
            money %= 100;
        }
        if (money >= 50) {
            wallet.set(6, money / 50);
            money %= 50;
        }
        if (money >= 10) {
            wallet.set(7, money / 10);
            money %= 10;
        }
        if (money >= 1) {
            wallet.set(8, money / 1);
            money %= 1;
        }
        return wallet;
    }
}