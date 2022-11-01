package onboarding;

import onboarding.problem2.SolveBrownCryptogram;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        SolveBrownCryptogram solveBrownCryptogram = new SolveBrownCryptogram();
        if (solveBrownCryptogram.isFailedInputValidation(cryptogram)) throw new IllegalArgumentException();

        answer = solveBrownCryptogram.removeDuplicationSpelling(cryptogram);

        return answer;
    }
}
