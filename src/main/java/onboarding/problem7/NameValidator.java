package onboarding.problem7;

public class NameValidator {

    private static final Integer MINIMUM_LENGTH = 1;
    private static final Integer MAXIMUM_LENGTH = 30;

    public static void validateName(String name) {
        validateNameLength(name);
        validateNameIsLowerCase(name);
    }

    private static void validateNameIsLowerCase(String name) {
        if (!name.equals(name.toLowerCase())) {
            throw new IllegalArgumentException("아이디는 소문자이어야 합니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다.");
        }
    }
}
