package onboarding.problem3.domain;

import java.util.List;

public class Game369Strategy implements GameStrategy {

    private static final List<String> checkList = List.of("3", "6", "9");

    @Override
    public boolean satisfyCondition(int number) {
        String checkNumberText = String.valueOf(number);
        return checkList.stream()
                .anyMatch(checkNumberText::contains);
    }
}
