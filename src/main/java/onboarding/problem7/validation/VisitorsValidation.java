package onboarding.problem7.validation;

import java.util.List;

public class VisitorsValidation {
    private static final int MAX_VISITORS_SIZE = 10_000;
    private static final String VISITOR_LENGTH_EXCEPTION_MESSAGE = "visitor의 아이디 길이는 1이상 30이하여야 합니다.";
    private static final String VISITORS_SIZE_EXCEPTION_MESSAGE = "visitors의 길이는 길이가 0이상 10,000이하여야 합니다.";
    private static final String VISITOR_LOWERCASE_EXCEPTION_MESSAGE = "visitor의 아이디 길이는 소문자로 구성되어야 합니다.";

    public static void validate(List<String> visitors) {
        validateVisitorsSize(visitors);
        validateVisitorsId(visitors);
    }

    private static void validateVisitorsSize(List<String> visitors) {
        if ((visitors.size() > MAX_VISITORS_SIZE)) {
            throw new IllegalArgumentException(VISITORS_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateVisitorsId(List<String> visitors) {
        for (String visitor : visitors) {
            validateVisitorId(visitor);
        }
    }

    private static void validateVisitorId(String friendId) {
        if (!IdValidation.validateIdLengthInRange(friendId)) {
            throw new IllegalArgumentException(VISITOR_LENGTH_EXCEPTION_MESSAGE);
        }
        if (!IdValidation.validateIsLowerCaseId(friendId)) {
            throw new IllegalArgumentException(VISITOR_LOWERCASE_EXCEPTION_MESSAGE);
        }
    }
}
