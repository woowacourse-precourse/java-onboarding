package onboarding;

public class Problem4 {
    public static char transformChar(char ch) {
        if(Character.isLowerCase(ch)) {
            char diff = (char) ('A' - 'a');

            return Character.toLowerCase(transformChar(Character.toUpperCase(ch)));
        }

        int MID_COUNT = ('Z' - 'A' )/ 2;
        char startChar = 'A';
        char endChar = 'Z';

        if(ch < MID_COUNT) {
            return (char) (ch - startChar + endChar);
        } else {
            return (char) (endChar - ch + startChar);
        }
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
