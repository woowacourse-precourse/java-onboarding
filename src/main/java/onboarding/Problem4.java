package onboarding;

import onboarding.problem4.LetterReverser;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (char letter : word.toCharArray()) {
            char changedLetter = LetterReverser.reverseOnlyEnglish(letter);
            sb.append(changedLetter);
        }
        return sb.toString();
    }
}
