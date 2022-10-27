package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static int countClap(int number) {

        List<Integer> digits = new ArrayList<>();
        int result;

        result = 0;
        for (int i = 1; i <= number; i++) {

            digits = parseNum(i);   // 숫자 분리

            for (int n : digits) {  // 분리된 숫자 3, 6, 9 비교

                if (compareNumWith369(n)) { // 비교 후 참이면 카운트 증가
                    result++;
                }

            }

        }

        return result;

    }

    public static List<Integer> parseNum(int number) {

        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }

        return digits;
    }

    public static boolean compareNumWith369(int digit) {

        int Array[] = {3, 6, 9};

        for (int n : Array) {
            if (digit == n) {
                return true;
            }
        }

        return false;

    }

    public static int solution(int number) {
        int answer = 0;
        answer = countClap(number);
        return answer;
    }


}
