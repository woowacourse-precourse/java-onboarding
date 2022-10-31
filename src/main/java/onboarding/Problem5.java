package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        List<Integer> unit = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int i = 0 ; i < unit.size() ; i++) {
            answer.add( money / unit.get(i) );
            money = money - (( money / unit.get(i) ) * unit.get(i));
            }
        return answer;
    }
}
