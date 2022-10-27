package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char w : word.toCharArray()) {
            if(w == ' ') answer += " ";
            else answer += translate(w);
        }

        return answer;
    }

    private static char translate(char w) {
        char c;
        if (97 <= w && w <= 122) {
            c = (char) (122 - (w - 97));
        } else {
            c = (char) (90 - (w - 65));
        }
        return c;
    }
}
