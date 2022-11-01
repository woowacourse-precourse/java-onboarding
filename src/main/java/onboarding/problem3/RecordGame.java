package onboarding.problem3;

public class RecordGame {
    private final Integer count;

    public RecordGame(int count) {
        this.count = count;
    }
    public static RecordGame generateEmptyCount(){
        return new RecordGame(0);
    }

    public RecordGame plus(int count) {
        return new RecordGame(this.count + count);
    }

    public Integer count() {
        return count;
    }
}
