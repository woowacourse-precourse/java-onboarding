package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static final int THREE=3;
    private static final int SIX=6;
    private static final int NINE=9;

    public static int solution(int number) {
        int answer = 0;

        for (int i=1;i<=number;i++) {
            List<Integer> arrayOfNumbers = convertToArray(i);   // 1 ~ number 의 정수를 정수 배열로 변환
            answer += countNumbers(arrayOfNumbers);             // 3,6,9의 개수 구하여 answer 에 합하기
        }
        return answer;
    }

    private static List<Integer> convertToArray(int number) {
        List<Integer> arr = new ArrayList<>();
        while (number > 0) {
            arr.add(number % 10);
            number /= 10;
        }
        return arr;
    }

    private static int countNumbers(List<Integer> arr) {
        int count = 0;
        for (Integer a : arr) {
            count += addCount(a);
        }
        return count;
    }

    private static int addCount(Integer a) {
        if (isThree(a) || isSix(a) || isNine(a)) {
            return 1;
        }
        return 0;
    }

    private static boolean isThree(Integer i) {
        return (i == THREE);
    }
    private static boolean isSix(Integer i) {
        return (i == SIX);
    }

    private static boolean isNine(Integer i) {
        return (i == NINE);
    }
}
