package onboarding.problem1;

import java.util.Arrays;

public class SumPageCalculator implements PageCalculator {
    @Override
    public int calc(String[] pageSplitStrings) {
        return Arrays.stream(pageSplitStrings).mapToInt(Integer::valueOf).sum();
    }
}
