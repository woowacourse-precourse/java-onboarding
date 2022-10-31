package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isInvalid(pobi) || isInvalid(crong)) {
            return -1;
        }

        int maxValueOfPobi = pobi.stream()
            .map(Problem1::getMaxValue)
            .mapToInt(x-> x)
            .max().orElse(-1);

        int maxValueOfCrong = crong.stream()
            .map(Problem1::getMaxValue)
            .mapToInt(x-> x)
            .max().orElse(-1);

        if (maxValueOfPobi < 0 || maxValueOfCrong < 0 ) {
            return -1;
        }

        return maxValueOfPobi > maxValueOfCrong ? 1 :
            (maxValueOfPobi == maxValueOfCrong ? 0 : 2);
    }

    private static boolean isInvalid(List<Integer> input) {
        return input.size() != 2
            || input.get(1) - input.get(0) != 1
            || input.get(0) % 2 != 1
            || input.get(0) <= 1
            || input.get(1) >= 400
            ;
    }

    private static int getMaxValue(Integer number) {
        List<Integer> digitList = getDigitListFrom(number);
        int sum = digitList.stream()
            .mapToInt(x-> x)
            .sum();
        int product = digitList.stream()
            .mapToInt(x -> x)
            .reduce(1, Math::multiplyExact);

        return Math.max(sum, product);
    }

    private static List<Integer> getDigitListFrom(Integer number) {
        List<Integer> digit = new ArrayList<>();
        while(number > 0) {
            digit.add(number % 10);
            number /= 10;
        }
        return digit;
    }
}