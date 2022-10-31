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
    private Set<Integer> clapNumbers = Set.of(3, 6, 9);
    private final int clap = 1;
    private final int doNotClap = 0;

    public ClapGame() {
    }

    public ClapGame(Set<Integer> clapNumbers) {
        setClapNumbers(clapNumbers);
    }

    public void setClapNumbers(Set<Integer> clapNumbers) {
        this.clapNumbers = clapNumbers;
    }

    public int play(int maxNumber) {
        int totalClap = 0;

        for (int number = 0; number <= maxNumber; number++) {
            totalClap += countClap(number);
        }

        return totalClap;
    }

    private int countClap(int number) {
        int clap = 0;

        while (number > 0) {
            int placeNumber = number % 10;
            clap += isClapNumber(placeNumber);

            number /= 10;
        }

        return clap;
    }

    private int isClapNumber(int placeNumber) {
        if (clapNumbers.contains(placeNumber)) {
            return clap;
        }

        return doNotClap;
    }
}
