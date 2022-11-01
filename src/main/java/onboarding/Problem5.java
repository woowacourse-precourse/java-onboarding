package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> divide_Money(int money){
        List<Integer> list = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> count = new ArrayList<>();

        for (int i=0; i<list.size(); i++){
            count.add(money / list.get(i));
            money %= list.get(i);
        }
        return count;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = divide_Money(money);

        return answer;
    }
}
