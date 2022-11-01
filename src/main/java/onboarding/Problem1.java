package onboarding;

import onboarding.problem1.controller.PageNumberGame;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = new PageNumberGame().startGame(pobi, crong).getGameResult();
        return answer;
    }
}