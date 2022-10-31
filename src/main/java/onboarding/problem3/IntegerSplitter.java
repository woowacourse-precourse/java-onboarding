package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class IntegerSplitter {
    private final int target;

    public IntegerSplitter(int target) {
        this.target = target;
    }

    public List<Integer> getSplitList() {
        List<Integer> outcome = new ArrayList<>();
        int operand = target;
        while (operand > 0) {
            outcome.add(0, operand % 10);
            operand /= 10;
        }
        return outcome;
    }
}
