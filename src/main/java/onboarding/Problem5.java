package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    static class Money{
        private int amount;
        private int count;
        Money(int amount, int count){
            this.amount = amount;
            this.count = count;
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        LinkedList<Money> wallet = getWallet();
        return answer;
    }
    public static LinkedList<Money> getWallet(){
        LinkedList<Money> wallet = new LinkedList<>();
        wallet.add(new Money(50000, 0));
        wallet.add(new Money(10000, 0));
        wallet.add(new Money(5000, 0));
        wallet.add(new Money(1000, 0));
        wallet.add(new Money(500, 0));
        wallet.add(new Money(100, 0));
        wallet.add(new Money(50, 0));
        wallet.add(new Money(10, 0));
        wallet.add(new Money(1, 0));
        return wallet;
    }
}
