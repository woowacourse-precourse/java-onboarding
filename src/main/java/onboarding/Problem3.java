package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            Integer num = i;
            char[] digits = num.toString().toCharArray();

            for (char digit:digits) {
                if ((digit == '3') || (digit == '6') || (digit == '9')) {
                    ++answer;
                }
            }
        }

        return answer;
    }
}
