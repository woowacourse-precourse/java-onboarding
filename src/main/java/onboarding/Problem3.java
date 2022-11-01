package onboarding;

public class Problem3 {
    private static final char THREE = '3';
    private static final char SIX = '6';
    private static final char NINE = '9';

    public static int solution(int number) {
        return countClap(number);
    }

    public static int countClap(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += countNumber(i);
        }

        return sum;
    }

    private static int countNumber(Integer num) {
        String numString = num.toString();

        int cnt = 0;
        for (char numChar : numString.toCharArray()) {
            if (include369(numChar)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean include369(char num) {
        return num == THREE || num == SIX || num == NINE;
    }
}
