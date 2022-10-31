package onboarding;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

class ChangeMoney{
    private static List<Integer> bills = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
    private List<Integer> changes;
    public List<Integer> setChange(int money){
        this.changes = new ArrayList<>();
        for(int i=0;i<bills.size();i++){
            int billCnt = (int)(money/bills.get(i));
            this.changes.add(billCnt);
            money -= billCnt*bills.get(i);
        }
        return this.changes;
    }
}
public class Problem5 {
    public static List<Integer> solution(int money) {
        ChangeMoney changeMoney = new ChangeMoney();
        return changeMoney.setChange(money);
    }
}
