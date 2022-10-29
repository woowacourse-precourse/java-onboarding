package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static List<Integer> calculateNumberOfBills(int placeValue, List<Integer> billNumbers) {
        billNumbers.add(placeValue % 5); // (placeValue * 1)원 개수
        billNumbers.add(placeValue / 5); // (placeValue * 5)원 개수
        return billNumbers;
    }

}
