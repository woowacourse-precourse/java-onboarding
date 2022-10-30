package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        List<Integer> moneyTypeList = Arrays.asList(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
        insertQuotientListByGreedy(answer, money, moneyTypeList);
        return answer;
    }

    private static void insertQuotientListByGreedy(List<Integer> answerList, int money, List<Integer> moneyTypeList) {
        for (int moneyType :
                moneyTypeList) {
            int quotient = money / moneyType;
            answerList.add(quotient);

            money %= moneyType;
        }
    }
}
