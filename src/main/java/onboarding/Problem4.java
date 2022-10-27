package onboarding;

import onboarding.problem4.WordConverter;

public class Problem4 {
    public static String solution(String word) {
        try {
            if (word.length() < 1 || 1000 < word.length()) {
                throw new Exception("Word length is out of range.");
            }

            String answer = WordConverter.convertWord(word);

            return answer;
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
