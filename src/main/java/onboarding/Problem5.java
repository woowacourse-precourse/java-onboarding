package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getChangeMoneyCountList(money);
        return answer;
    }

    static List<Integer> getChangeMoneyCountList(int m){
        List<Integer> ChangeMoneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<Integer>();
        int money = m;
        for(int i=0;i<ChangeMoneyList.size();i++){
            int count = 0;
            int change = ChangeMoneyList.get(i);
            count = money/change;
            answer.add(count);
            money -= count*change;
        }

        return answer;
    }
}
