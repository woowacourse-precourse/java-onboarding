package onboarding.problem3;

public class GeneralTermClapper implements Clapper{
    private final int[] MAX_CLAP_BY_DIGIT = {12000, 900, 60, 3, 0}; // a[n-1 - i] = 3 * (10 ^ (i-1)) + 10 * a[n-i - (i-1)]  (i >= 1)
    private final int[] MULTIPLES_OF_TEN = {10000, 1000, 100, 10, 1};
    public int getNumOfClap(int n) {
        int answer = 0;
        answer += getTotalClap(n);
        return answer;
    }
    private int getTotalClap(int number) {
        int totalClap = 0;
        int[] numbers = toInts(zeroPadding(number));
        for(int i = 0; i < numbers.length; i++) {
            totalClap += getClapByDigit(numbers[i], i, number);
        }
        return totalClap;
    }

    private int getClapByDigit(int digit, int i, int number) {
        if (digit == 0) return 0;
        int clap = getClapDefault(digit, i);
        if (digit % 3 == 0) {
            clap += getClapMulOfThree(i, number);
        }
        return clap;
    }

    private int getClapDefault(int digit, int i) {
        return digit * MAX_CLAP_BY_DIGIT[i] + getNumOfMulOfThreeLessThanValue(digit) * MULTIPLES_OF_TEN[i];
    }

    private int getClapMulOfThree(int i, int number) {
        return number % MULTIPLES_OF_TEN[i] + 1;
    }

    private int getNumOfMulOfThreeLessThanValue(int value) {
        return (value-1) / 3;
    }

    private String zeroPadding(int number) {
        return String.format("%05d", number);
    }

    private int[] toInts(String value) {
        int[] numbers = new int[value.length()];
        for(int i = 0; i < value.length(); i++) {
            numbers[i] = value.charAt(i) - '0';
        }
        return numbers;
    }
}
