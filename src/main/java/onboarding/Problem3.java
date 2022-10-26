package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (containThreeSixNine(i)) {
                answer += countThreeSixNine(i);
            }
        }
        return answer;
    }

    public static boolean containThreeSixNine(int num) {
        String str = Integer.toString(num);
        return str.contains("3") || str.contains("6") || str.contains("9");
    }

    public static int countThreeSixNine(int num) {
        String[] str = Integer.toString(num).split("");
        return (int)Arrays.stream(str).filter(i -> i.equals("3") || i.equals("6") || i.equals("9")).count();
    }
}
