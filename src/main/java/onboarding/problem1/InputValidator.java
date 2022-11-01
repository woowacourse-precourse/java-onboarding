package onboarding.problem1;

import java.util.List;

public class InputValidator {

    private final int MAX_PAGE;

    public InputValidator(int maxPage) {
        MAX_PAGE = maxPage;
    }

    public boolean validate(List<Integer> pages) {
        return validateSize(pages.size()) && validateValues(pages.get(0), pages.get(1));
    }

    private boolean validateSize(int size) {
        return size == 2;
    }

    private boolean validateValues(int left, int right) {
        return left < MAX_PAGE && 1 < right && left + 1 == right && left % 2 == 1 && right % 2 == 0;
    }
}
