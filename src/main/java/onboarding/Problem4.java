package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] words = word.toCharArray();

        for (char w : words) {
            if (w == ' ') answer.append(" ");
            else if ('A' <= w && w <= 'Z') answer.append(reverseUpper(w));
            else if ('a' <= w && w <= 'z') answer.append(reverseLower(w));
        }

        return answer.toString();
    }

    public static char reverseUpper(char w) {
        return (char) ('A' + 'Z' - w);
    }

    public static char reverseLower(char w) {
        return (char) ('a' + 'z' - w);
    }
}
