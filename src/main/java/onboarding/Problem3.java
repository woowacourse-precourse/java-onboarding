package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Integer> separateList = separateToNumber(number);


        return answer;


    }
    private static List<Integer> separateToNumber(int number) {
        List<Integer> separate = new ArrayList<>();
        while (number > 0) {
            separate.add(number % 10);
            number = number / 10;
        }
        return separate;
    }
}
