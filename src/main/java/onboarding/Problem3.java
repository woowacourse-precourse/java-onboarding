package onboarding;

public class Problem3 {
    public static int countNumber(int number) {
        int count = 0;
        int dividedNumber = number;
        while(dividedNumber != 0) {
            int digit = dividedNumber % 10;
            if(digit == 3 | digit == 6 | digit == 9) {
                count = count + 1;
            }
            dividedNumber = dividedNumber / 10;
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
