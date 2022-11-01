package onboarding;

import onboarding.problem3.GameOf369;

public class Problem3 {

    public static int solution(int number) {

        GameOf369 gameOf369 = new GameOf369();
        int numberOfClaps = gameOf369.countAllClapsTo(number);
        return numberOfClaps;
    }
}
