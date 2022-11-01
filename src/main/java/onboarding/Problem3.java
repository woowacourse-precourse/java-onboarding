package onboarding;

import onboarding.support.problem3.GameUtil;

public class Problem3 {
    public static int solution(int number) {
        GameUtil gameUtil = new GameUtil(number);
        return gameUtil.getScore();
    }
}
