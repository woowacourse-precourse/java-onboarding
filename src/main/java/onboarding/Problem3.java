package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += calculateClapCount(i);
        }
        return answer;
    }

    private static int calculateClapCount(int num) {
        int sum = 0;
        int divided = num;
        while (divided != 0) {
            int digit = divided % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                sum++;
            }
            divided /= 10;
        }
        return sum;
    }
}
