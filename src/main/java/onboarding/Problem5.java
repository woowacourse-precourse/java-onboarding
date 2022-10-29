package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MoneyChanger{
    private int[] currencies = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public List<Integer> getChanges(int money){
        List<Integer> changes = new ArrayList<>();
        for(int i = 0; i < currencies.length; i++){
            changes.add(money / currencies[i]);
            money %= currencies[i];
        }
        return changes;
    }

}
public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyChanger changer = new MoneyChanger();
        return changer.getChanges(money);
    }
}
