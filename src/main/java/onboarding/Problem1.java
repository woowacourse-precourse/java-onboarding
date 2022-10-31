package onboarding;

import java.util.List;
import onboarding.prob1.domain.BookGame;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        BookGame bookGame = new BookGame();
        answer = bookGame.solve(pobi, crong);
        return answer;
    }

}