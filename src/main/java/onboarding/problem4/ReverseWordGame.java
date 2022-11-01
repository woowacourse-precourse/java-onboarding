package onboarding.problem4;

public class ReverseWordGame {
    private static final int MAX = 1_000;

    public static String start(String input) {
        validateInput(input);
        int[] chars = getInts(input);
        return new String(chars, 0, chars.length);
    }

    private static void validateInput(String input) {
        validateBlank(input);
        validateMAX(input);
    }

    private static void validateMAX(String input) {
        if (input.length() > MAX) {
            throw new ReverseException("1000 이상의 길이의 문자열은 입력할 수 없습니다");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new ReverseException("빈 값을 입력했습니다.");
        }
    }

    private static int[] getInts(String word) {
        return word.chars().map(
                ch -> Character.isUpperCase(ch) ? 25 - ch + 'A' * 2 :
                        Character.isLowerCase(ch) ? 25 - ch + 'a' * 2 : ch).toArray();
    }
}
