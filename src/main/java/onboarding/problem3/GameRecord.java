package onboarding.problem3;

public class GameRecord {
    private final Integer count;

    public GameRecord(int count) {
        this.count = count;
    }

    public static GameRecord generateEmptyCount() {
        return new GameRecord(0);
    }

    public GameRecord plus(int count) {
        return new GameRecord(this.count + count);
    }

    public Integer count() {
        return count;
    }
}
