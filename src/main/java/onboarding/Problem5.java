package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int fiftyThousand = money / 50000;
        int tenThousand = money % 50000 / 10000 ;
        int fiveThousand= money % 50000 % 10000 / 5000;
        int oneThousand = money % 50000 % 10000 % 5000 / 1000;
        int fiveHundred = money % 50000 % 10000 % 5000 % 1000 / 500;
        int oneHundred = money % 50000 % 10000 % 5000 % 1000 % 500 / 100;
        int fifty = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50;
        int ten = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10;
        int one = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10;

        answer.add(fiftyThousand);
        answer.add(tenThousand);
        answer.add(fiveThousand);
        answer.add(oneThousand);
        answer.add(fiveHundred);
        answer.add(oneHundred);
        answer.add(fifty);
        answer.add(ten);
        answer.add(one);

        return answer;
    }
}
