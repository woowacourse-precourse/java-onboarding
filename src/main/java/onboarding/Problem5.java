package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        System.out.println(money);

        int fiveMillion = money / 50000;
        int changes = money % 50000;
        int million = changes / 10000;
        int changes2 = changes % 10000;
        int fiveThousand = changes2 / 5000;
        int changes3 = changes2 % 5000;
        int thousand = changes3 / 1000;
        int changes4 = changes3 % 1000;
        int fiveHundred = changes4 / 500;
        int changes5 = changes4 % 500;
        int hundred = changes5 / 100;
        int changes6 = changes5 % 100;
        int fifty = changes6 / 50;
        int changes7 = changes6 % 50;
        int ten = changes7 / 10;
        int one = changes7 % 10;

       ArrayList<Integer> answer = new ArrayList<Integer>();

        answer.add(fiveMillion);
        answer.add(million);
        answer.add(fiveThousand);
        answer.add(thousand);
        answer.add(fiveHundred);
        answer.add(hundred);
        answer.add(fifty);
        answer.add(ten);
        answer.add(one);

        System.out.println(answer);
        return answer;
    }
}
