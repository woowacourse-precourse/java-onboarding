package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!isValidate(number)) {
            return -1;
        }
        return getSumOfCount(number);
    }

    /**
     * 제한사항을 검증하는 기능
     */
    private static boolean isValidate(int number) {
        return (number > 0 && number < 10001);
    }

    /**
     * 3과 6과 9의 개수를 세는 기능
     */
    private static int getSumOfCount(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += countClap(i, 0);
        }
        return sum;
    }

    private static int countClap(int number, int result) {
        if (number == 0) {
            return result;
        }
        if (isClapNumber(number % 10)) {
            result++;
        }
        return countClap(number / 10, result);
    }

    private static boolean isClapNumber(int number) {
        return (number == 3 || number == 6 || number == 9);
    }
}
