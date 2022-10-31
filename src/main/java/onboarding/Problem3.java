package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int n = 1; n <= number; n++) {}
        return answer;
    }

    private static Boolean isClapNum(int number) {
        while (number > 0) {
            int eachNum = number % 10;
            if (List.of(3, 6, 9).contains(eachNum)) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
