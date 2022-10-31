package onboarding;

import java.util.List;
import onboarding.pagenumbergame.entity.GamePlay;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        GamePlay game = GamePlay.of(pobi, crong);

        int answer = game.play();
        return answer;
    }
}
