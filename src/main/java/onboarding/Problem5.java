package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        Integer []currency= {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i=0; i<=8; i++){
            int counter = money/ currency[i];
            money = money - currency[i]*counter;
            currency[i] = counter;
        }

        answer = java.util.Arrays.asList(currency);
        return answer;
    }
}
