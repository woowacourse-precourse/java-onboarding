package onboarding;

import onboarding.problem3.controller.SamYukGuGame;

public class Problem3 {
    public static int solution(int number) {
        int answer = new SamYukGuGame().setNumber(number).startGame().getTotalHandClapCount();
        return answer;
    }
}
