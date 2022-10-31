package onboarding;

import onboarding.problem1.Game;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!(isRight(pobi) && isRight(crong))) return -1;
        int resultPobi = new Game(pobi.get(0), pobi.get(1)).getResult();
        int resultCrong = new Game(crong.get(0), crong.get(1)).getResult();
        if(resultCrong == resultPobi) return 0;
        return (resultPobi > resultCrong)? 1 : 2;
    }

    private static boolean isRight(List<Integer> list) {
        return isRightPage(list) && isNotFirstOrLastPage(list);
    }

    private static boolean isNotFirstOrLastPage(List<Integer> list) {
        boolean cond1 = (list.get(0) != 0);
        boolean cond2 = (list.get(1) != 400);
        return cond1 && cond2;
    }

    private static boolean isRightPage(List<Integer> list) {
        if(list.get(0) > list.get(1)) return false;
        boolean cond1 = (list.get(0)%2 == 1);
        boolean cond2 = (list.get(1)%2 == 0);
        return cond1 && cond2;
    }
}