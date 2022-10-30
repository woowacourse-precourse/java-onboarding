package onboarding;

public class Problem4 {
    public static final int UPPER_SUM = 155;
    public static final int LOWER_SUM = 219;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char toFrogChar(char c) {
        if(Character.isUpperCase(c))
            return (char)(UPPER_SUM-c);
        if(Character.isLowerCase(c))
            return (char)(LOWER_SUM-c);
        return c;
    }
}
