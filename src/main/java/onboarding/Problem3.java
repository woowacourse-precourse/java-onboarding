package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int numberSize = 0;

        String str = Integer.toString(number);
        numberSize = str.length();

        for (int i = 0; i < numberSize; i++) {
            int digit = (int) Math.pow(10, i);
            int currDigitNum;

            if (i == 0) {
                currDigitNum = number % (digit * 10);
                answer += currDigitNum / 3;
                continue;
            }

            currDigitNum = (number / digit) % 10;

            if (currDigitNum != 0 && currDigitNum % 3 == 0) {
                answer += (number % digit) + 1;
            }

            answer += ((currDigitNum - 1) / 3) * digit;
            answer += (number / digit) * 3 * (digit / 10);
        }
        return answer;
    }
}
