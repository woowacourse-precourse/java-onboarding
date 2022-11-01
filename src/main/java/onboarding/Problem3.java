package onboarding;

import onboarding.problem3.ThreeSixNineGame;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        ThreeSixNineGame threeSixNineGame = new ThreeSixNineGame(number);
        answer = threeSixNineGame.runGame();
        return answer;
    }
}
