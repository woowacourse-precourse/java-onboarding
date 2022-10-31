package onboarding.problem3;

public class GameOperator {

    private final CustomIterator<Integer> iterator;

    public GameOperator(CustomIterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public void start() {
        iterator.iterateOnCondition();
    }
}
