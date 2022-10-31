package onboarding;

public class Problem3 {
    public static int count369(int number) {
        int result = 0;
        String stringNumber = String.valueOf(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            int digit = stringNumber.charAt(i) - '0';

            if (digit == 3 || digit == 6 || digit == 9) result++;
        }
        return result;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }
}
