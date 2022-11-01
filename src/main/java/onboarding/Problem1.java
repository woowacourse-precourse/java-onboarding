package onboarding;

import java.util.List;
import onboarding.problem01.entity.GamePlay;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        GamePlay game = GamePlay.of(pobi, crong);

        int answer = game.play();
        return answer;
    }
}
