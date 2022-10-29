package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char c : word.toCharArray())
            answer += decode(c);

        return answer;
    }

    private static char decode(char c) {
        return '0';
    }
}
