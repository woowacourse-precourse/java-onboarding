package onboarding.problem4;

public class ReverseWordGame {
    public static int start(String input) {
        validateBlank(input);
        return 1;
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new ReverseException("빈 값을 입력했습니다.");
        }
    }
}
