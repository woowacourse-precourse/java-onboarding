package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countClap(number);
    }

    public static int countClap(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += count369(i);
        }

        return sum;
    }

    private static int count369(Integer num) {
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
        return num == '3' || num == '6' || num == '9';
    }
}
