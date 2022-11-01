package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class ChangeBill {
    private int money;
    private int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private List<Integer> krwWonCount = new ArrayList<>();

    public ChangeBill(int money){
        this.money = money;
    }

    public List<Integer> changeBills(){
        for(int bill : bills){
            krwWonCount.add(money / bill);
            money %= bill;
        }

        return krwWonCount;
    }
}
