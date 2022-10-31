package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;

import java.util.List;

public class VisitorsValidator extends AbstractValidator {
    public static final int MIN_VISITORS_SIZE = 0;
    public static final int MAX_VISITORS_SIZE = 10_000;
    public static final String VISITORS = "Visitors";

    public static void validate(List<String> visitors) {
        isSizeOfListInValidRange(VISITORS, visitors, MIN_VISITORS_SIZE, MAX_VISITORS_SIZE);
    }
}
