package onboarding;

import onboarding.problem4.AlphabetFactory;
import onboarding.problem4.WordValidator;

public class Problem4 {

    static StringBuilder answer;
    static char[] words;

    static void input(String oldWord) {
        answer = new StringBuilder();
        words = oldWord.toCharArray();
    }

    static String doConvertWord(String oldWord) {
        input(oldWord);

        for (char word : words) {
            if (Character.isAlphabetic(word)) {
                word = AlphabetFactory.doConvert(word);
            }
            answer.append(word);
        }

        return answer.toString();
    }

    public static String solution(String word) {
        WordValidator.validateWord(word);
        return doConvertWord(word);
    }
}
