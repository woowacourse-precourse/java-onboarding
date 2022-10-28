package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    /**
     * 숫자의 각 자릿수를 나누는 함수
     * ex) 123 -> [3, 2, 1]
     */
    private static List<Integer> splitDigit(int num) {
        List<Integer> digitList = new ArrayList<>();
        int rest = num;
        while (rest > 0) {
            int digit = rest % 10;
            rest = rest / 10;

            digitList.add(digit);
        }

        return digitList;
    }

    /**
     * 박수를 쳐야하는 횟수를 구하는 함수
     */
    private static int getClapCount(List<Integer> digitList) {
        return Integer.MAX_VALUE;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
