package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> coinTypes = asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int type : coinTypes) {
            int a = money / type;
            answer.add(a);
            money = money % type;
        }
        System.out.println(answer);
        return answer;
    }
}
