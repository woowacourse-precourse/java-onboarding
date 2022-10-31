package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> unitList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        int index = 0;
        for (int unit : unitList) {
            int quotient = money / unit;
            answer.add(index, quotient);
            money -= unit * (quotient);
            index += 1;
        }

        return answer;
    }

}
