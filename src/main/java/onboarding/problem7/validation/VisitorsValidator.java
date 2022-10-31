package onboarding.problem7.validation;

import onboarding.common.AbstractValidator;

import java.util.List;

public class VisitorsValidator extends AbstractValidator {
    public static final String INVALID_VISITORS_SIZE_MESSAGE_FORMAT = "주어진 방문자 수는 %d개 이상 %d개 이하여야 합니다.";
    public static final int MIN_VISITORS_SIZE = 0;
    public static final int MAX_VISITORS_SIZE = 10_000;

    @Override
    public boolean supports(Object target) {
        return target.getClass() == List.class;
    }

    @Override
    public void validate(Object target) {
        if (supports(target)) {
            validateVisitors((List<String>) target);
        }
    }

    public static void validateVisitors(List<String> visitors) {
        isVisitorSizeValid(visitors);
    }

    private static void isVisitorSizeValid(List<String> visitors) {
        if (visitors == null || MAX_VISITORS_SIZE < visitors.size()) {
            throw new IllegalArgumentException(String.format(INVALID_VISITORS_SIZE_MESSAGE_FORMAT, MIN_VISITORS_SIZE, MAX_VISITORS_SIZE));
        }
    }
}
