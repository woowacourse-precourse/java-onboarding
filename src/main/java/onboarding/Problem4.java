package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += convertTo(word.charAt(i));
        }
        return answer;
    }

    static char convertTo(char c) {
        final int LOWER_SUM = 'a' + 'z';
        final int UPPER_SUM = 'A' + 'Z';

        if (Character.isLowerCase(c)) {
            return (char)(LOWER_SUM - c);
        }
        else if(Character.isUpperCase(c)) {
            return (char)(UPPER_SUM - c);
        }
        else {
            return c;
        }
    }
}
