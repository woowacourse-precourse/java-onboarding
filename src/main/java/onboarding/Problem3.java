package onboarding;

import java.util.Set;

public class Problem3 {

    /**
     * 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
     *
     * @param number 주어지는 최대 숫자
     * @return 손뼉 횟수
     */
    public static int solution(int number) {
        ClapGame clapGame = new ClapGame();
        return clapGame.play(number);
    }
}

class ClapGame {
    private final Set<Integer> clapNumbers = Set.of(3, 6, 9);
    private final static int CLAP = 1;
    private final static int DO_NOT_CLAP = 0;

    public int play(int maxNumber) {
        int totalClap = 0;

        for (int number = 0; number <= maxNumber; number++) {
            totalClap += getClapCount(number);
        }

        return totalClap;
    }

    private int getClapCount(int number) {
        int clapCount = 0;

        while (number > 0) {
            int placeNumber = number % 10;
            clapCount += isClapNumber(placeNumber);

            number /= 10;
        }

        return clapCount;
    }

    private int isClapNumber(int placeNumber) {
        if (clapNumbers.contains(placeNumber)) {
            return CLAP;
        }

        return DO_NOT_CLAP;
    }
}
