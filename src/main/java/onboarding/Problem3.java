package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem3 {
    /**
     * 369게임을 할 때, 1부터 {@code number}까지 손뼉을 쳐야하는 횟수를 리턴합니다.
     */
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            List<Integer> digits = parseIntegerToDigits(i);
            answer += countOccurencesOf369(digits);
        }

        return answer;
    }

    /**
     * 리스트의 원소 중 3, 6, 9의 개수를 리턴합니다.
     */
    private static Integer countOccurencesOf369(List<Integer> list) {
        Long count = list.stream()
            .filter(x -> (x == 3) || (x == 6) || (x == 9))
            .count();

        return count.intValue();
    }

    /**
    * 정수의 각 자릿수를 원소로 가지는 리스트를 리턴합니다.
    */
    private static List<Integer> parseIntegerToDigits(Integer value) {
        ArrayList<Integer> digits = new ArrayList<>();

        while (value > 0) {
            Integer lastDigit = value % 10;
            digits.add(0, lastDigit);
            value /= 10;
        }

        return digits;
    }
}
