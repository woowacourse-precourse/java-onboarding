package onboarding;

import onboarding.problem1.BookGame;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        BookGame bookGame = new BookGame(pobi, crong);
        answer = bookGame.start();

        return answer;
    }
}