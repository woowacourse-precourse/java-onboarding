package onboarding;

import onboarding.domain.PageScore;

import java.util.List;

class Problem1 {
    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            PageScore pobiScore = new PageScore(pobi);
            PageScore crongScore = new PageScore(crong);
            return pobiScore.compareTo(crongScore);
        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }
    }
}