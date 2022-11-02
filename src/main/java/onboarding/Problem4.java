package onboarding;

import java.nio.charset.StandardCharsets;

public class Problem4 {
    public static String solution(String word) {
        if(!validate(word)) return "Invalid Input";

        String answer = new String(decrypt(word).getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);

        return answer;
    }

    private static boolean validate(String word) {
        if (word.length() < 1 || word.length() > 1000) return false;
        return true;
    }

    private static String decrypt(String word) {
        //한글입력꼬임
        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            outputBuilder.append(getMatchingCharacter(cur));
        }

        return outputBuilder.toString();
    }

    private static char getMatchingCharacter(char input) {
        if (!isAlphabet(input)) return input;

        boolean isUpperCase = 'a' > input;
        char standard = isUpperCase ? 'A' : 'a';

        int index = input - standard;
        return (char) (standard + 25 - index);
    }

    private static boolean isAlphabet(char input) {
        if (65 <= input && input <= 90) return true;
        else if (97 <= input && input <= 122) return true;

        return false;
    }
}
