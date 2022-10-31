package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageGame pageGame;
        try {
            pageGame = new PageGame(pobi, crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        return pageGame.result();
    }
}
