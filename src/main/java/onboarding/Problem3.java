package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClapNum(i);
        }

        return answer;
    }

    private static int countClapNum(int number) {
        String numberStr = String.valueOf(number);

        int rtVal = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            int c = numberStr.charAt(i) - '0';

            if (c != 0 && c % 3 == 0) {
                rtVal++;
            }
        }

        return rtVal;
    }
}
