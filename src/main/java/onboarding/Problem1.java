package onboarding;

import onboarding.problem1.Game;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = Game.calculate(pobi.get(0), pobi.get(1));
        int crongMax = Game.calculate(crong.get(0), crong.get(1));

        return Game.compare(pobiMax,crongMax);
    }
}