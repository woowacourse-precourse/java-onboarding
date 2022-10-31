package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            List<Integer> array = getArray(i);
            answer += countClap(array);
        }

        return answer;
    }

    private static List<Integer> getArray(int number) {
        List<Integer> result = new ArrayList<>();

        while (number > 0) {
            result.add(number % 10);
            number /= 10;
        }
        return result;
    }

    private static int countClap(List<Integer> array) {
        int count = 0;
        for (int i : array) {
            if (isClap(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isClap(int num) {
        if (num == 0) return false;
        return num % 3 == 0;
    }
}
