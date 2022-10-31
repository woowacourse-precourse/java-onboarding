package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 가장 큰 화폐부터 해당 화폐로 출금이 가능한지 확인한다.
        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i] <= money) {
                int number = money / currencies[i];
                count[i] += number;
                money -= number * currencies[i];
            }
        }
        return Arrays.asList(count);
    }
}