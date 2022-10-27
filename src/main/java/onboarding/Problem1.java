package onboarding;

import onboarding.p1.Judge;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Judge judge = new Judge(pobi, crong);
        return judge.getAnswer();
    }
}