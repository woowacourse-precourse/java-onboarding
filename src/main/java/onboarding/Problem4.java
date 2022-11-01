package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char c : word.toCharArray()) {
            answer += convertAlphabet(c);
        }
        return answer;
    }
    private static boolean isAlphabet(char c) {
        return ('A' <= c && c <= 'z') || ('a' <= c && c <= 'z');
    }

    private static char convertAlphabet(char c) {

        if (!isAlphabet(c))
            return c;
        if (Character.isUpperCase(c))
            return (char)(155 -(int)c);
        else
            return (char)(219 -(int)c);
    }
}
