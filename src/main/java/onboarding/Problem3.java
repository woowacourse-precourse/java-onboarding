package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static int countClap(int number) {

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

    }

    public static int solution(int number) {
        int answer = 0;

        return answer;
    }


}
