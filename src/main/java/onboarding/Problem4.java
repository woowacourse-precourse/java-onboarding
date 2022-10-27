package onboarding;

import onboarding.problem4.AlphabetFactory;
import onboarding.problem4.WordValidator;

public class Problem4 {

    static StringBuilder answer;

    static void input() {
        answer = new StringBuilder();
    }

    static String doConvertWord(String oldWord) {
        input();
        final char[] words = oldWord.toCharArray();

        for (char word : words) {
            if (!Character.isAlphabetic(word)) {
                answer.append(word);
                continue;
            }
            final Character convertAlphabet = AlphabetFactory.doConvert(word);
            answer.append(convertAlphabet);
        }
        return answer.toString();
    }

    public static String solution(String word) {
        WordValidator.validateWord(word);
        return doConvertWord(word);
    }


}
