package onboarding;

import onboarding.problem3.ThreefoldGamer;

/**
 * Problem 3 function list
 * - Running game (search each number)
 * - Count threefold nums of single number
 */
public class Problem3 {
    public static int solution(int number) {
        ThreefoldGamer gamer = new ThreefoldGamer(number);
        return gamer.runGame();
    }
}
