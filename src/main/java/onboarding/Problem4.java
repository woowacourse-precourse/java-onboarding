package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char w : word.toCharArray()) {
            if(97 <= w && w <= 122) answer += translateSmall(w);
            else if(65 <= w && w <= 90) answer += translateBig(w);
            else answer += w;
        }

        return answer;
    }

    private static char translateBig(char w) {
        return (char) (90 - (w - 65));
    }

    private static char translateSmall(char w) {
        return (char) (122 - (w - 97));
    }

}
