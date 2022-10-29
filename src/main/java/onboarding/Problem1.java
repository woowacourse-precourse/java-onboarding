package onboarding;

import onboarding.problem1.Controller;
import onboarding.problem1.Service;

import java.util.List;

class Problem1 {

    private static Controller controller;

    Problem1(Controller controller) {
        this.controller = controller;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Integer answer = controller.startGame(pobi, crong);
        return answer;
    }
}