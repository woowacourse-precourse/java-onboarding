package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char convertUpper(char c) {
        int ascii = c;

        return (char) (Math.abs(ascii - 90) + 65);
    }

    private static char convertLower(char c) {
        int ascii = c;

        return (char) (Math.abs(ascii - 122) + 97);
    }
}
