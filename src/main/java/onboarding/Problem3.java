package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!isOutOfRange(number)) {
            return 0;
        }

        return sumClaps(number);
    }

    private static boolean isOutOfRange(int number) {
        return number >= 1 && number <= 10000;
    }

    private static int countClap(String number, char tsn) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == tsn) {
                count++;
            }
        }
        return count;
    }

    private static int sumClaps(int number){
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            String strNum = Integer.toString(i);
            sum += countClap(strNum, '3') + countClap(strNum, '6') + countClap(strNum, '9');
        }

        return sum;
    }
}
