package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int numberSize = 0;

        String str = Integer.toString(number);
        numberSize = str.length();

        for(int i = 0; i < numberSize; i++) {
            int digits = (int)Math.pow(10, i);
            int currDigitsNum;

            if( i == 0) {
                currDigitsNum = number % (digits * 10);
                answer += currDigitsNum / 3;
                continue;
            }

            currDigitsNum = (number / digits) % 10;

            if(currDigitsNum != 0 && currDigitsNum % 3 == 0) {
                answer += (number % digits) + 1;
            }

            answer += ((currDigitsNum - 1) / 3) * digits;
            answer += (number / digits) * 3 * (digits / 10);
        }
        return answer;
    }
}
