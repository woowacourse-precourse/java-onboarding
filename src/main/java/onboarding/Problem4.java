package onboarding;

public class Problem4 {

    public static char getEncryptChar(char ch) {
        if ('A' <= ch && ch <= 'Z') {
            return (char) ('Z' - (ch - 'A'));
        } else if ('a' <= ch && ch <= 'z') {
            return (char) ('z' - (ch - 'a'));
        } else {
            return ch;
        }
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            answer.append(getEncryptChar(word.charAt(i)));
        }
        return answer.toString();
    }
}
