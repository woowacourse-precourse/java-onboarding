package onboarding.problem3;

public class Game {
    private RecordGame recordGame;

    public Integer run(Integer number) {
        this.recordGame = RecordGame.generateEmptyCount();
        for (int i = 1; i <= number; i++) {
            this.recordGame = recordGame.plus(Number.calculateContainThreeOrSixOrNineCount(i));
        }
        return recordGame.count();
    }
}
