package onboarding.problem3.objects;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int START_NUMBER = 1;
    private int gameNumber;
    private Validation validation;
    private List<Integer> claps;

    public Game(int number) {
        this.gameNumber = number;
        this.validation = new Validation(number);
        this.claps = new ArrayList<>();
    }

    public int start() {
        Rule rule = new Rule(new Clap());
        processPhase(rule);
        return getClapCount();
    }

    private void processPhase(Rule rule) {
        for (int num = START_NUMBER; num <= this.gameNumber; num++) {
            claps.add(rule.numberComeTrue(num));
        }
    }

    private int getClapCount() {
        return claps.stream().mapToInt(Integer::valueOf).sum();
    }
}
