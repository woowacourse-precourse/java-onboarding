package onboarding.problem7;

public class UserValidator {
  public static void validate(String user) {
    if (!IDValidator.isLowerCaseId(user)) {
      throw new IllegalArgumentException("유저의 아이디 길이 범위 초과 소문자로 구성");
    }

    if (!IDValidator.isIdLengthInRange(user)) {
      throw new IllegalArgumentException("유저의 아이디 길이 범위 초과 1이상 30이하");
    }
  }
}
