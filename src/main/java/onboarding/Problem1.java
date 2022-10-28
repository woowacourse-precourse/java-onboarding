package onboarding;

import java.util.List;

import onboarding.problem1.vo.Pages;
import onboarding.problem1.service.ScoreService;
import onboarding.problem1.validation.PageValidator;
import onboarding.problem1.vo.Score;

class Problem1 {
    public static final int EXCEPTION_RETURN_VALUE = -1;
    public static final int POBI_WINNER_RETURN_VALUE = 1;
    public static final int CRONG_WINNER_RETURN_VALUE = 2;
    public static final int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPages = Pages.of(pobi);
            Pages crongPages = Pages.of(crong);

            PageValidator.isInValidPages(pobiPages);
            PageValidator.isInValidPages(crongPages);

            Score pobiScore = ScoreService.getHighestScore(pobiPages);
            Score crongScore = ScoreService.getHighestScore(crongPages);

            if (pobiScore.isHigherThan(crongScore)) {
                return POBI_WINNER_RETURN_VALUE;
            } else if (pobiScore.isLowerThan(crongScore)) {
                return CRONG_WINNER_RETURN_VALUE;
            }

            return TIE;
        } catch (IllegalArgumentException exception) {
            return EXCEPTION_RETURN_VALUE;
        }
    }
}
