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
            if (value.charAt(i) == '3' || value.charAt(i) == '6' || value.charAt(i) == '9') {
                result++;
            }
        }
        return result;
    }
}
