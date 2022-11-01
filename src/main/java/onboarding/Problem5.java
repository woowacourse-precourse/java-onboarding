package onboarding;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Problem5 {

    public static List<Integer> solution(int money) {

        int result[] = new int[9];

        int moneyUnit = 50000;
        int sw = 0;

        for (int i = 0; i < result.length; i++) {
            try {
                result[i] = money / moneyUnit;
                money = money % moneyUnit;
            } catch (ArithmeticException ae) {
            }
            if (sw == 0) {
                sw = 1;
                moneyUnit /= 5;
            } else if (sw >= 1 && money < 10) {
                moneyUnit /= 10;
            } else {
                sw = 0;
                moneyUnit /= 2;
            }
        }
        List<Integer> answer = IntStream.of(result).boxed().collect(Collectors.toList());
        Collections.emptyList();

        return answer;
    }
}
