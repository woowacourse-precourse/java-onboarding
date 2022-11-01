package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem5 {

    public static void main(String[] args) {
        int k = 50237;
        System.out.println(solution(k));
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int k = money;
        answer.add(k / 50000);
        k %= 50000;
        answer.add(k / 10000);
        k %= 10000;
        answer.add(k / 5000);
        k %= 5000;
        answer.add(k / 1000);
        k %= 1000;
        answer.add(k / 500);
        k %= 500;
        answer.add(k / 100);
        k %= 100;
        answer.add(k / 50);
        k %= 50;
        answer.add(k / 10);
        k %= 10;
        answer.add(k);
        return answer;
    }
}
