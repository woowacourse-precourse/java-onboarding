package onboarding;

import java.util.List;

import static onboarding.problem1.Comparator.decideWinner;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return decideWinner(pobi,crong);
    }
}