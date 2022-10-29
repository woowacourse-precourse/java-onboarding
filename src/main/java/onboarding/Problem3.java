package onboarding;

import static java.lang.Integer.*;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }

    public static int count369(int number){
        int clapCount = 0;
        char[] array = String.valueOf(number).toCharArray();

        for (char c : array) {
            if (is369(characterToInteger(c))) {
                clapCount++;
            }
        }

        return clapCount;
    }

    private static boolean is369(int checkNum) {
        return true;
    }

    private static int characterToInteger(char c) {
        return parseInt(String.valueOf(c));
    }
}
