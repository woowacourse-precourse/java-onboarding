package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            if (!(('a' <= wordChar && wordChar <= 'z') || ('A' <= wordChar && wordChar <= 'Z'))) {
                answer += wordChar;
                continue;
            }
            String reversedString = getReversedString(wordChar);
            answer += reversedString;
        }

        return answer;
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
