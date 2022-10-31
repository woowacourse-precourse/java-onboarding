package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            if (!isAlphabet(wordChar)) {
                answer += wordChar;
                continue;
            }
            answer += getReversedString(wordChar);
        }

        return answer;
    }

    private static boolean isAlphabet(char wordChar) {
        return ('a' <= wordChar && wordChar <= 'z') || ('A' <= wordChar && wordChar <= 'Z');
    }

    private static String getReversedString(char ch) {
        char reversedString;
        if (ch >= 97) {
            reversedString = (char) (25 - (ch - 'a') + 'a');
            return reversedString + "";
        }
        reversedString = (char) (25 - (ch - 'A') + 'A');
        return reversedString + "";

    }

}
