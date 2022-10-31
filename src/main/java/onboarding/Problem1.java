package onboarding;

import onboarding.exception.InputException;
import onboarding.problem1.BookScoreComparator;

import java.util.List;

public class Problem1 {

    private static final int EXCEPTIONAL_CIRCUMSTANCES = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            return new BookScoreComparator().compare(pobi, crong);
        } catch (InputException e){
            return EXCEPTIONAL_CIRCUMSTANCES;
        }
    }
}