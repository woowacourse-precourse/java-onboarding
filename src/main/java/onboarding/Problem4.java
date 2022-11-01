package onboarding;

import onboarding.problem4.controller.AlphabetContrayConvertor;

public class Problem4 {
    public static String solution(String word) {
        String answer = new AlphabetContrayConvertor().setWord(word).convert().getConvertedWord();
        return answer;
    }
}
