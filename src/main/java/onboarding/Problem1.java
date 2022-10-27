package onboarding;

import onboarding.problem1.exception.PageNumberException;
import onboarding.problem1.game.PageNumberGame;

import java.util.List;

import static onboarding.problem1.constance.Constance.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (PageNumberException.validates(pobi) == EXCEPTION_MESSAGE ||
                PageNumberException.validates(crong) == EXCEPTION_MESSAGE) {
            return EXCEPTION_MESSAGE;
        }

        int pobiScore = PageNumberGame.saveMaxPageNumberByUser(pobi);
        int crongScore = PageNumberGame.saveMaxPageNumberByUser(crong);

        return PageNumberGame.winnerUser(pobiScore, crongScore);
    }
}