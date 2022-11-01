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

        answer.add(remain/1000);
        remain = remain%1000;

        answer.add(remain/500);
        remain = remain%500;

        answer.add(remain/100);
        remain = remain%100;

        answer.add(remain/50);
        remain = remain%50;

        answer.add(remain/10);
        remain = remain%10;

        answer.add(remain/1);

        return answer;
    }
}
