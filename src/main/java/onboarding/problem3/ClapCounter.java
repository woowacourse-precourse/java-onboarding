package onboarding.problem3;

import java.util.List;

public class ClapCounter {
    private final int now;

    public ClapCounter(int now) {
        this.now = now;
    }

    public int getClapCount() {
        List<Integer> parsedList = new IntegerSplitter(now).getSplitList();
        int totalCount = 0;

        return parsedList.stream().reduce(totalCount, this::getClapCountWithOne);
    }

    private int getClapCountWithOne(int total, int number) {
        if (isClap(number)) {
            return total + 1;
        }
        return total;
    }

    private boolean isClap(int number) {
        if (number == 3) {
            return true;
        }
        if (number == 6) {
            return true;
        }
        return number == 9;
    }
}
