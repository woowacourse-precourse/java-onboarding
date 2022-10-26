package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    
    private static int countOfThreeSixNine(int number) {
        return (int) Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .filter(eachDigit -> eachDigit % 3 == 0)
                .count();
    }
}
