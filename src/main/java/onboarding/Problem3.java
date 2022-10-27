package onboarding;

public class Problem3 {
    private final static int[] MAX_CLAP_BY_DIGIT = {12000, 900, 60, 3, 0}; // a[n-1 - i] = 3 * (10 ^ (i-1)) + 10 * a[n-i - (i-1)]  (i >= 1)
    private final static int[] MULTIPLES_OF_TEN = {10000, 1000, 100, 10, 1};
    public static int solution(int number) {
        int answer = 0;
        answer += getTotalClap(number);
        return answer;
    }
    private static int getTotalClap(int number) {
        int totalClap = 0;
        int[] numbers = toInts(zeroPadding(number));
        for(int i = 0; i < numbers.length; i++) {
            totalClap += getClapByDigit(numbers[i], i, number);
        }
        return totalClap;
    }

    private static int getClapByDigit(int digit, int i, int number) {
        if (i == 0) return 0;
        int clap = getClapDefault(digit, i);
        if (i % 3 == 0) {
            clap += number / (MULTIPLES_OF_TEN[i]);
        }
        return clap;
    }

    private static int getClapDefault(int digit, int i) {
        return digit * MAX_CLAP_BY_DIGIT[i] + getNumOfMulOfThreeLessThanValue(digit) * (MULTIPLES_OF_TEN[i] / 10);
    }

    private static int getNumOfMulOfThreeLessThanValue(int value) {
        return (value-1) / 3;
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
