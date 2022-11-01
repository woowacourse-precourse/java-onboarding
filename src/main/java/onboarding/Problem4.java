package onboarding;

public class Problem4 {

    public static Character changeAlpha(Character c) {
        if ((int)c == 32) {
            return c;
        }
        else if (Character.isUpperCase(c)) {
            return (char)Math.abs(155 - (int)c);
        }
        else {
            return (char)Math.abs(219 - (int)c);
        }
    }

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            answer += changeAlpha(c);
        }

        return answer;
    }
}
