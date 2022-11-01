package onboarding;

import onboarding.problem3.GeneralTermClapper;

public class Problem3 {

    public static int solution(int number) {
        GeneralTermClapper clapper = new GeneralTermClapper();
        return clapper.getNumOfClap(number);
    }

}
