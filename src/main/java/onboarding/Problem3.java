package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static boolean isClap(int number) {
        return number == 3 || number == 6 || number == 9;
    }

    private static List<Integer> getPlaceValues(int number) {
        List<Integer> placeValues = new ArrayList<>();
        while (number > 0) {
            placeValues.add(number % 10);
            number /= 10;
        }
        return placeValues;
    }
}
