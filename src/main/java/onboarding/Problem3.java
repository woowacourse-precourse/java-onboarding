package onboarding;

import onboarding.problem3.domain.Game369Strategy;
import onboarding.problem3.domain.GameStrategy;
import onboarding.problem3.service.NumberGameService;

public class Problem3 {
    public static int solution(int number) {
        GameStrategy game369Strategy = new Game369Strategy();
        NumberGameService numberGameService = new NumberGameService(game369Strategy);
        return numberGameService.result(number);
    }
}
