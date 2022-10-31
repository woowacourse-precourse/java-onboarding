package onboarding.problem1;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
        PageGame game = new PageGame(pobi, crong);

            return game.start();
        }catch (RuntimeException e){
            return -1;
        }
    }
}