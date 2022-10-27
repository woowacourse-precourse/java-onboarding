package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getCount(i);
        }

        return answer;
    }

    private static int getCount(int number) {
        int count = 0;

        while(number > 0) {
            if (checkNumber(number % 10)) {
                count++;
            }

            number /= 10;
        }

        return count;
    }

    private static boolean checkNumber(int number) {

        if (number == 3 || number == 6 || number == 9) {
            return true;
        } else {
            return false;
        }

    }
}
