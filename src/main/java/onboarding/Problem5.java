package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        System.out.println(answer);
        answer = 
        withdraw(money);

        return answer;
    }

    private static List<Integer> withdraw(int money) {
        List<Integer> list = Collections.emptyList();
        list.add(100);
        System.out.println(list);
        System.out.println("ASD");

        while (true) {

            if (money >= 50000) {
                money /= 50000;
            } else if (money >= 10000) {
                money /= 10000;
            } else if (money >= 5000) {
                money /= 5000;
            } else if (money >= 1000) {
                money /= 1000;
            } else if (money >= 500) {
                money /= 500;
            } else if (money >= 100) {
                money /= 100;
            } else if (money >= 50) {
                money /= 50;
            } else if (money >= 10) {
                money /= 10;
            } else {
                money /= 1;
            }
            break;

        }

        return list;
    }
}
