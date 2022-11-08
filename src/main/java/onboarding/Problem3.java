package onboarding;

import onboarding.problem3.Clapper;
import onboarding.problem3.GeneralTermClapper;
import onboarding.problem3.LoopClapper;

public class Problem3 {

    public static int solution(int number) {
        Clapper clapper = new LoopClapper();
        return clapper.getNumOfClap(number);
    }

}
