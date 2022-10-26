package onboarding;

import onboarding.problem1.BookGame;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        BookGame bookGame = new BookGame(pobi, crong);
        int answer = bookGame.getPlayResult();
        return answer;
    }
}