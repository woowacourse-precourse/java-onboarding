package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String num = Integer.toString(i);
            answer += getClapNumber(num);
        }
        return answer;
    }

    public static int getClapNumber(String num) {
        if (containThreeSixNine(num)) {
            return countThreeSixNine(num);
        }
        return 0;
    }

    public static boolean containThreeSixNine(String num) {
        return num.contains("3") || num.contains("6") || num.contains("9");
    }

    public static int countThreeSixNine(String num) {
        String[] str = num.split("");
        return (int)Arrays.stream(str).filter(i -> i.equals("3") || i.equals("6") || i.equals("9")).count();
    }
}
