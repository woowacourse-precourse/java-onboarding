package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] result = new int[9];
        List<Integer> indexmine = List.of(1, 3, 5, 7, 8);
        char[] moneylastdigit = String.valueOf(money).toCharArray();

        for (int i = moneylastdigit.length - 1; i >= 0; i--) {
            int moneyDigit = moneylastdigit[i] - '0';
            if (i != moneylastdigit.length - 1 && moneyDigit >= 5) {
                result[indexmine.get(i) - 1]++;
                result[indexmine.get(i)] = moneyDigit - 5;
            } else {
                result[indexmine.get(i)] = moneyDigit;
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
