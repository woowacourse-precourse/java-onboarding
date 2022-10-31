package onboarding;

import onboarding.pkgProblem4.service.changeOppositeLetterService;

public class Problem4 {
    public static String solution(String word) {
        changeOppositeLetterService chgLetter = new changeOppositeLetterService();

        return chgLetter.changeLetter(word);
    }
}
