package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] result = new int[9];
        List<Integer> indexOfDigits = List.of(1, 3, 5, 7, 8);
        char[] moneyDigits = String.valueOf(money).toCharArray();

        for (int i = moneyDigits.length - 1; i >= 0; i--) {
            int moneyDigit = moneyDigits[i] - '0';

            if (i != moneyDigits.length - 1 && moneyDigit >= 5) {
                result[indexOfDigits.get(i) - 1]++;
                result[indexOfDigits.get(i)] = moneyDigit - 5;
            } else {
                result[indexOfDigits.get(i)] = moneyDigit;
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
