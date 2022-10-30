package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneys = List.of(50000,10000,5000,1000,500,100,50,10,1);

        for(int i = 0; i < moneys.size(); i++) {
            int target = moneys.get(i);
            int temp = money / target;
            money = money % target;
            answer.add(temp);

        }

        return answer;
    }
}
