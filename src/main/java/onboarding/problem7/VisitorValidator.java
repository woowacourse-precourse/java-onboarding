package onboarding.problem7;

import java.util.List;

public class VisitorValidator {
  private static final int MAX_VISITORS_SIZE = 10000;

  public static void validate(List<String> visitors) {
    validateVisitorsSize(visitors);
    validateVisitorsId(visitors);
  }

  private static void validateVisitorsSize(List<String> visitors) {
    if ((visitors.size() > MAX_VISITORS_SIZE)) {
      throw new IllegalArgumentException("visitor 길이 범위 초과 10000이하");
    }
  }

  private static void validateVisitorsId(List<String> visitors) {
    visitors.forEach(VisitorValidator::validateVisitorId);
  }

  private static void validateVisitorId(String friendId) {
    if (!IDValidator.isIdLengthInRange(friendId)) {
      throw new IllegalArgumentException("visitor ID 범위 초과 1이상 30이하");
    }
    if (!IDValidator.isLowerCaseId(friendId)) {
      throw new IllegalArgumentException("visitor ID 길이는 소문자로 구성");
    }
  }
}
