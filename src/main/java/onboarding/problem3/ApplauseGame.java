package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class ApplauseGame {
    private final List<Boolean> claps = new ArrayList<>();

    public int start(int number, ClapRule clapRule) {
        ApplauseParameter applauseParameter = new ApplauseParameter(number);
        String numbers = applauseParameter.getNumbers();

        for (int i = 0; i < numbers.length(); i++) {
            claps.add(clapRule.isClap(numbers, i));
        }
        return getAnInt(claps);
    }

    private int getAnInt(List<Boolean> claps) {
        return Math.toIntExact(claps.stream().filter(clapOrNot -> clapOrNot).count());
    }

}
