package onboarding.problem7;

public class NameValidator {

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
        if (name.length() < 1 || name.length() > 30) {
            throw new IllegalArgumentException("아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다.");
        }
    }
}
