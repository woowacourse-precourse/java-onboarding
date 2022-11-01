package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number + 1; i++) {
            answer += checkNumber(i);
        }

        return answer;
    }

    private static int checkNumber(int number) {
        return (int) makeList(number).stream()
            .filter(c -> c.equals("3") || c.equals("6") || c.equals("9"))
            .count();
    }

    private static List<String> makeList(int number) {
        return Arrays.asList(Integer.toString(number).split(""));
    }

}
