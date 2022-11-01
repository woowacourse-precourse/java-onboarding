package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {

    public static int solution(int number) {
        return getTotalClapNumber(number);
    }

    private static int getTotalClapNumber(int number) {
        int totalClapNumber = 0;
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            totalClapNumber += getClapNumber(currentNumber);
        }
        return totalClapNumber;
    }

    private static int getClapNumber(int number) {
        List<Integer> placeValues = getPlaceValues(number);
        return getClapPlaceValues(placeValues).size();
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
