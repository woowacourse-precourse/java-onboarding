package onboarding;

import onboarding.problem1.domain.Players;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return new Players(pobi, crong).playResult();
    }
}