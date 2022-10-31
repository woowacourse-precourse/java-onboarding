package onboarding;

import onboarding.problem03.entity.GameStation;

public class Problem3 {
    public static int solution(int number) {
        GameStation station = GameStation.from(number);
        int answer = station.gameScore();
        return answer;
    }
}
