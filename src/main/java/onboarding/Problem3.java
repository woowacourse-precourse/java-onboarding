package onboarding;

public class Problem3 {

    public static int countOf369(int num) {
        int sum = 0;
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            int digit = strNum.charAt(i) - '0';
            if (digit == 3 || digit == 6 || digit == 9) {
                sum++;
            }
        }
        return sum;
    }

    public static boolean validation(int number) {
        if (number < 1 || number > 10000) {
            return false;
        } else {
            return true;
        }
    }

    public static int solution(int number) {
        int sum = 0;

        if (validation(number)) {
            return -1;
        }

        for (int i = 1; i <= number; i++) {
            sum += countOf369(i);
        }
        return sum;
    }
}
