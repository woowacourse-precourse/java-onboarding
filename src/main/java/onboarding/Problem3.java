package onboarding;

import onboarding.problem3.ClapGame;

public class Problem3 {
    static final int MAX_NUMBER = 10000;
    static final int MIN_NUMBER = 1;
    public static int solution(int number) {
        if (!validateGameNumber(number)) {
            return -1;
        }
        int answer = ClapGame.countNumberOfClap(number);
        return answer;
    }

    public static boolean validateGameNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            return false;
        }
        return true;
    }
}
