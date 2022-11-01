package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> chunk = new ArrayList<Integer>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        int idx = 0;
        int num;
        while (idx < chunk.size()){
            num = money / chunk.get(idx);
            answer.add(num);
            money -= num * chunk.get(idx);
            idx++;
        }
        return answer;
    }
}
