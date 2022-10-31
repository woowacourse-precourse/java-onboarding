package onboarding;

public class Problem4 {
    public static String solution(String word) {

        char[] frogWord = new char[1000];
        for (int i = 0; i < word.length(); i++) {
            frogWord[i] = changeCase(word.charAt(i));
        }

        return String.valueOf(frogWord).substring(0,word.length());
    }

    // 대소문자 변경하기
    private static char changeCase(char ch) {
        if (ch >= 97 && ch <= 122) { // 소문자
            return (char) ('z' - (ch - 'a'));
        } else if (ch >= 65 && ch <= 90) { // 대문자
            return (char) ('Z' - (ch - 'A'));
        } else return ch;
    }
}
