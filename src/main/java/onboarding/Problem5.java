package onboarding;


import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    static class Money{
        private final int amount;
        private int count;
        Money(int amount, int count){
            this.amount = amount;
            this.count = count;
        }

        public int getAmount(){
            return this.amount;
        }

        public void setCount(int count){
            this.count = count;
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        LinkedList<Money> wallet = getWallet();
        setMoneyCount(wallet, money);
        for(Money object: wallet){
            answer.add(object.count);
        }
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

    public static void setMoneyCount(LinkedList<Money> wallet, int money){
        for (Money object : wallet) {
            object.setCount(Math.floorDiv(money, object.getAmount()));
            money = Math.floorMod(money, object.getAmount());
        }
    }
}
