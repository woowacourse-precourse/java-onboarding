package onboarding;

import java.util.Arrays;

public class MulPageCalculator implements PageCalculator {
    @Override
    public int calc(String[] pageSplitStrings) {
        return Arrays.stream(pageSplitStrings).mapToInt(Integer::valueOf).reduce(1,(left, right)->left*right);
    }
}
