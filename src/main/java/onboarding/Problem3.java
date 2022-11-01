package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            String value = String.valueOf(i);
            result = validateHandclap(value, result);
        }
        return result;
    }

    private static int validateHandclap(String value, int result) {
        for (int i = 0; i < value.length(); i++) {
            if (validateHandClap(value.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    private static boolean validateHandClap(char clapCharacter) {
        if (clapCharacter == '3' || clapCharacter == '6' || clapCharacter == '9') {
            return true;
        }
        return false;
    }
}
