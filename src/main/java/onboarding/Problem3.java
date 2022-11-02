package onboarding;


import problem3.Game;

public class Problem3 {
    public static int solution(int number) {
        Game game = new Game(number);
        int answer = game.run();
        return answer;
    }
}
