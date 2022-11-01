package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i <= word.length() - 1; i++) {
            answer += convertToTreeFrogWord(word.charAt(i));
        }
        return answer;
    }

    public static char convertToTreeFrogWord(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            char alphabet = (char) (ch - 'A');
            return (char) ('Z' - alphabet);
        } else if (ch >= 'a' && ch <= 'z') {
            char alphabet = (char) (ch - 'a');
            return (char) ('z' - alphabet);
        }
        return ch;
    }

}
