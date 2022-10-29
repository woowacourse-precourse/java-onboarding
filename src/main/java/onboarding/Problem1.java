package onboarding;

import java.util.List;
import onboarding.problem1.GamePlayer;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return GamePlayer.play(pobi, crong);
    }
}