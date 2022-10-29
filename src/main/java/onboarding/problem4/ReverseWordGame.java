package onboarding.problem4;

public class ReverseWordGame {
    private static final int MAX = 1_000;

    public static int start(String input) {
        validateBlank(input);
        validateMAX(input);
        return 1;
    }

    private static void validateMAX(String input) {
        if (input.length() > MAX){
            throw new ReverseException("1000 이상의 길이의 문자열은 입력할 수 없습니다");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new ReverseException("빈 값을 입력했습니다.");
        }
    }
}
