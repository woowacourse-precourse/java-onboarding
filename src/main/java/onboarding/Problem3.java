package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return count369From1ToNum(number);
    }

    private static int count369From1ToNum(int num) {
        int answer = 0;
        int totalDigit = 0;
        for(int i = 1; i < num; i *= 10) {
            answer += count369OnNthDigitFrom1ToNum(num, totalDigit);
            totalDigit++;
        }

        return answer;
    }

    private static int count369OnNthDigitFrom1ToNum(int number, int digit) {
        int count = 0;
        int divider = 1;

        for(int i = 0; i < digit; i++) {
            divider *= 10;
        }

        for(int i = divider; i <= number; i++) {
            if(is369OnFirstDigit(i / divider)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean is369OnFirstDigit(int num) {
        return (num % 3 == 0) && (num % 10 != 0);
    }
}
