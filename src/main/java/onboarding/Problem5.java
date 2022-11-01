package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<Integer>();

        moneyCount(money,50000, answer);
        money %= 50000;
        moneyCount(money,10000, answer);
        money %= 10000;
        moneyCount(money,5000, answer);
        money %= 5000;
        moneyCount(money,1000, answer);
        money %= 1000;
        moneyCount(money,500, answer);
        money %= 500;
        moneyCount(money,100, answer);
        money %= 100;
        moneyCount(money,50, answer);
        money %= 50;
        moneyCount(money,10, answer);
        money %= 10;
        moneyCount(money,1, answer);

        return answer;
    }

    public static List<Integer> moneyCount(int money, int number, List<Integer> answer){

        int count = 0;
        count = money / number;
        answer.add(count);

        return answer;

    }
}
