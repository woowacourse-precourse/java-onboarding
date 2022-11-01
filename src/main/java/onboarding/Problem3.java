package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static List<Integer> getClapPlaceValues(List<Integer> placeValues) {
        return placeValues.stream()
            .filter(Problem3::isClap)
            .collect(Collectors.toList());
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
