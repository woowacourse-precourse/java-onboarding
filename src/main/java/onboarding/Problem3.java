package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            System.out.println(getCount369(i));
        }

        return answer;
    }

    private static boolean getCount369(int number) {
        int checkNumber;

        while (number != 0) {
            checkNumber = number % 10;

            if (checkNumber == 3 || checkNumber == 6 || checkNumber == 9) {
                return true;
            }

            number /= 10;
        }

        return false;
    }
}
