package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class ApplauseGame {
    private static final List<Boolean> claps = new ArrayList<>();

    public static int start(ApplauseParameter applauseParameter, ClapRule clapRule) {
        String numbers = applauseParameter.getNumbers();

        for (int i = 0; i < numbers.length(); i++) {
            claps.add(clapRule.isClap(numbers, i));
        }
        int result = getAnInt();
        resetClaps();
        return result;
    }

    private static void resetClaps() {
        claps.clear();
    }

    private static int getAnInt() {
        return Math.toIntExact(ApplauseGame.claps.stream().filter(clapOrNot -> clapOrNot).count());
    }

}
