package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int i = 0; i < unit.size(); i++){
            int count = countNumberOfBills(unit.get(i), money);
            answer.add(count);
            money -= unit.get(i)*count;
        }

        return answer;
    }

    private static int countNumberOfBills(int unit, int money){
        int count = 0;
        if(money >= unit){
            count = money/unit;
        }
        return count;
    }

}
