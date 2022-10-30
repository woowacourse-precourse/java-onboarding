package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();

        List<Integer> answer = new ArrayList<Integer>();
        int money50000, money10000, money5000, money1000, money500, money100, money50, money10, money1;

        money50000 = money / 50000;
        money -= money50000 * 50000;

        money10000 = money / 10000;
        money -= money10000 * 10000;

        money5000 = money / 5000;
        money -= money5000 * 5000;

        money1000 = money / 1000;
        money -= money1000 * 1000;

        money500 = money / 500;
        money -= money500 * 500;

        money100 = money / 100;
        money -= money100 * 100;

        money50 = money / 50;
        money -= money50 * 50;

        money10 = money / 10;
        money -= money10 * 10;

        money1 = money % 10;

        answer.add(money50000);
        answer.add(money10000);
        answer.add(money5000);
        answer.add(money1000);
        answer.add(money500);
        answer.add(money100);
        answer.add(money50);
        answer.add(money10);
        answer.add(money1);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(50237));
    }
}
