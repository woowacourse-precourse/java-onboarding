package onboarding.problem3.objects;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int START_NUMBER = 1;
    private final int gameNumber;
    private final List<Integer> claps;
    private final Rule rule;

    public Game(int number, Rule rule) {
        Validation validation = new Validation(number);
        this.gameNumber = number;
        this.rule = rule;
        this.claps = new ArrayList<>();
    }

    public int start() {
        processPhase(this.rule);
        return getClapCount();
    }

    private void processPhase(Rule rule) {
        for (int num = START_NUMBER; num <= this.gameNumber; num++) {
            Player player = new Player(num);
            int clapCount = player.numberComeTrue(num, rule);
            claps.add(clapCount);
        }
    }

    private int getClapCount() {
        return claps.stream().mapToInt(Integer::valueOf).sum();
    }
}
