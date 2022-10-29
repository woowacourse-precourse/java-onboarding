package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int count369(int number) {
        int result = 0;
        List<Integer> numberList = new ArrayList<>();

        String numberString = String.valueOf(number);
        Arrays.stream(numberString.split(""))
                .mapToInt(Integer::parseInt)
                .forEach(numberList::add);

        for (int n: numberList) {
            if (n == 3 || n == 6 || n == 9) {
                result++;
            }
        }

        return result;
    }
}
