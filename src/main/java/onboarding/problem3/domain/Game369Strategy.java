package onboarding.problem3.domain;

import java.util.Arrays;
import java.util.List;

public class Game369Strategy implements GameStrategy {

    private static final List<String> checkList = List.of("3", "6", "9");

    @Override
    public boolean satisfyCondition(int number) {
        String checkNumberText = String.valueOf(number);
        return checkList.stream()
                .anyMatch(checkNumberText::contains);
    }

    @Override
    public int count(int number) {
        if (satisfyCondition(number)) {
            return Long.valueOf(Arrays.stream(String.valueOf(number).split(""))
                    .filter(checkList::contains)
                    .count()).intValue();
        }
        return 0;
    }
}
