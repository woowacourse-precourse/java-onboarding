package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> numberList = new ArrayList<>();

        for(int i = 1; i <= number; i++){
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

        for (int i = 0; i < numberList.size(); i++) {
            if (isThreeSixNine(numberList.get(i))) {
                clap++;
            }
        }
        return clap;
    }

    public static boolean isThreeSixNine(int number) {
        if (number == 3 || number == 6 || number == 9) {
            return true;
        }
        return false;
    }

}