package onboarding;

import problem1.BattleResult;
import problem1.Page;
import problem1.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Problem1 {
    private static final int EXCEPTION_CODE = -1;

    public static int solution(List<Integer> pobiPageNumbers, List<Integer> crongPageNumbers) {
        try {
            Player pobi = new Player(asPages(pobiPageNumbers));
            Player crong = new Player(asPages(crongPageNumbers));


            BattleResult battleResult = pobi.battleWith(crong);
            return battleResult.getCode();
        } catch (RuntimeException e) {
            return EXCEPTION_CODE;
        }
    }

    public static List<Page> asPages(List<Integer> pageNumbers) {
        List<Page> result = new ArrayList<>();
        for (Integer pageNumber : pageNumbers) {
            result.add(new Page(pageNumber));
        }
        return result;
    }




}