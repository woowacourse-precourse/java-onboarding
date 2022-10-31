package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        

        return answer;
    }

    private static char convert(char c) {
        if (c >= 65 && c <= 90) {
            return (char) (155 - c);
        }
        if (c >= 97 && c <= 122) {
            return (char) (219 - c);
        }
        return c;
    }
}
