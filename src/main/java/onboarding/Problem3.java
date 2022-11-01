package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ClapCount {
    /* 박수 횟수 Integer Wrapping */
    private int clapCount;

    public ClapCount() {
        this.clapCount = 0;
    }

    public void clap() {
        this.clapCount += 1;
    }

    public int getClapCount() {
        return this.clapCount;
    }
}

class Game369 {
    private final List<Integer> condition = new ArrayList<>(Arrays.asList(3, 6, 9));
    private ClapCount clapCount;

    public int play(final int endNumber) {
        /* endNumber까지 369 게임을 하면서 박수친 횟수 return */
        this.clapCount = new ClapCount();
        for (int n = 1; n <= endNumber; n++) {
            count369(n);    // 숫자 n에서 3, 6, 9가 들어 있는 횟수 카운트
        }
        return this.clapCount.getClapCount();
    }

    private void count369(int number) {
        while (number > 0) {
            count(number % 10);
            number /= 10;
        }
    }

    private void count(int number) {
        if (this.condition.contains(number)) {
            this.clapCount.clap();
        }
    }
}

public class Problem3 {
    public static int solution(int number) {
        Game369 game = new Game369();
        return game.play(number);
    }
}