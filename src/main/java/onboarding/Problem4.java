package onboarding;

import onboarding.problem4.WordConverter;
import onboarding.problem4.exception.WordOutOfRangeException;

public class Problem4 {
    public static String solution(String word) {
        try {
            if (word.length() < 1 || 1000 < word.length()) {
                throw new WordOutOfRangeException("Word length is out of range.");
            }

            String answer = WordConverter.convertWord(word);

            return answer;
        } catch (WordOutOfRangeException e) {
            return e.getMessage();
        }

    }

}
