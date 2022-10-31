package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            int checkNumber = i;
            while (checkNumber != 0) {
                int divideNumber = checkNumber % 10;
                if (divideNumber != 0 && divideNumber % 3 == 0) {
                    answer++;
                }

                checkNumber /= 10;
            }
        }

        return answer;
    }
}
