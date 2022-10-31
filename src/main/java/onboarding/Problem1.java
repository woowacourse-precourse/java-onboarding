package onboarding;

import onboarding.problem1.PageGame;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            PageGame game = new PageGame();
            game.join(pobi,crong);
            return game.getWinner();
        }catch (Exception e){
            return -1;
        }

    }
}