package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> denom = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10,1));

        for (int i=0; i<denom.size(); i++){
            System.out.println(denom.get(i));
            System.out.println(money/denom.get(i));
            int count = money/denom.get(i);
            answer.add(count);
            // change money into remainder
            money%=denom.get(i);
        }

        return answer;
    }
}
