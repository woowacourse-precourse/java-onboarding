package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] currencyFaceValues = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> countPerCurrencyList = new ArrayList<>(currencyFaceValues.length);

        for (int faceValue : currencyFaceValues) {
            countPerCurrencyList.add(money / faceValue);
            money %= faceValue;
        }

        return countPerCurrencyList;
    }
}