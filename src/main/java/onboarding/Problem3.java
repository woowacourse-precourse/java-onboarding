package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static List<Integer> putDigitsToList(int number) {
        List<Integer> numberList = new ArrayList<>();
        while (number > 0) {
            numberList.add(number % 10);
            number /= 10;
        }
        return numberList;
    }

    public static boolean isThreeSixNine(int number) {
        if (number == 3 || number == 6 || number == 9) {
            return true;
        }
        return false;
    }

}