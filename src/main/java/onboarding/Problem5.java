package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList(); //immutable list
        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < 9; i++) {
            answer.add(i, change(i, money));
        }

        return answer;
    }

    private static Integer change(int i, int money) {
        switch (i) {
            case 0:
                return money / 50000;
            case 1:
                return money % 50000 / 10000;
            case 2:
                return money % 50000 % 10000 / 5000;
            case 3:
                return money % 50000 % 10000 % 5000 / 1000;
            case 4:
                return money % 50000 % 10000 % 5000 % 1000 / 500;
            case 5:
                return money % 50000 % 10000 % 5000 % 1000 % 500 / 100;
            case 6:
                return money % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50;
            case 7:
                return money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10;
            case 8:
                return money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10 / 1;
        }

        return 0;
    }
}
