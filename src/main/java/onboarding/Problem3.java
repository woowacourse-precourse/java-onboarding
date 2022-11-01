package onboarding;

import onboarding.problem3.Game;
import onboarding.problem3.Validation;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        try {
            Validation.validate(number);
            answer = Game.playGame(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
