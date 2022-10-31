package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<Integer>();

        return answer;
    }

    public static List<Integer> moneyCount(int money, int number, List<Integer> answer){

        int count = 0;
        count = money / number;
        answer.add(count);

        return answer;

    }
}
