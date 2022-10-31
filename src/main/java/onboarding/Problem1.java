package onboarding;

import problem1.Game;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Game game = new Game(pobi, crong);
            int answer = game.run();
            return answer;
        } catch(IllegalArgumentException ex) {
            return -1;
        }
    }
}