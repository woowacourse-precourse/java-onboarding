package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static int getResult(List<Integer> pagesOfPlayer1, List<Integer> pagesOfPlayer2) throws IllegalStateException{
        try {
            PagePair pairOfPlayer1 = new PagePair(pagesOfPlayer1);
            PagePair pairOfPlayer2 = new PagePair(pagesOfPlayer2);

            return pairOfPlayer1.comparePagePair(pairOfPlayer2);
        }catch (IllegalStateException e){
            return -1;
        }
    }

}
