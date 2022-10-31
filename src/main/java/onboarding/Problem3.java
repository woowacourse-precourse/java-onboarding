package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return count369(number);
    }

    private static int count369(int number) {
        int answer = 0;
        int totalDigit = 0;
        for(int i = 1; i < number; i *= 10) {
            answer += count369OnNthDigit(number, totalDigit);
            totalDigit++;
        }

        return answer;
    }

    private static int count369OnNthDigit(int number, int digit) {
        int count = 0;
        int divider = 1;

        for(int i = 0; i < digit; i++) divider *= 10;
        for(int i = divider; i <= number; i++) {
            if((i / divider) % 3 == 0 && (i / divider) % 10 != 0) count += 1;
        }
        return count;
    }
}
