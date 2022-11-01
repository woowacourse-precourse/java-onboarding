package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClaps(putDigitsToList(i));
        }
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

    public static int countClaps(List<Integer> numberList) {
        int clap = 0;
        for (int number : numberList) {
            clap += isThreeSixNine(number);
        }
        return clap;
    }

    public static int isThreeSixNine(int number) {
        if (number == 3 || number == 6 || number == 9) {
            return 1;
        }
        return 0;
    }
}