package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;

public class Problem5 {
    private static final int MAX_MONEY = 1000000;
    private static final int MIN_MONEY = 1;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        List<Integer> CURRENCY = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        if (!validatedMoney(money)) {
            try {
                throw new DataFormatException("INVALID_DATA_INPUT");
            } catch (DataFormatException e) {
                throw new RuntimeException(e);
            }
        }
        
        for (Integer integer : CURRENCY) {
            answer.add(money / integer);
            money = money - (money / integer) * integer;
        }
        return answer;
    }

    static boolean validatedMoney(int money) {
        return money <= MAX_MONEY && money >= MIN_MONEY;
    }
}
