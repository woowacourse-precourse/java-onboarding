package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int remain = money;

        answer.add(remain/50000);
        remain = remain%50000;

        answer.add(remain/10000);
        remain = remain%10000;

        answer.add(remain/5000);
        remain = remain%5000;

        return answer;
    }
}
