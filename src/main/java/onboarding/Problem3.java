package onboarding;

public class Problem3 {
    private final static int[] MAX_CLAP_BY_DIGIT = {12000, 900, 60, 3, 0}; // a[n-1 - i] = 3 * (10 ^ (i-1)) + 10 * a[n-i - (i-1)]  (i >= 1)
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    private static int getMaxClapByDigit(int i) {
        return MAX_CLAP_BY_DIGIT[i];
    }
    private static String zeroPadding(int number) {
        return String.format("%05d", number);
    }

    private static int[] toInts(String value) {
        int[] numbers = new int[value.length()];
        for(int i = 0; i < value.length(); i++) {
            numbers[i] = value.charAt(i) - '0';
        }
        return numbers;
    }
}
