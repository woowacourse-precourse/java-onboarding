package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++){
            answer += countClaps(i);
        }
        return answer;
    }
    private static int countClaps(int number) {
        int clap = 0;
        int result = 0;
        int divisor = 1000;
        for (int i = 0; i < 4; i++) {
            result = number / divisor;
            if (result != 0 && result % 3 == 0) {
                clap++;
            }
            number = number % divisor;
            divisor /= 10;
        }
        return clap;
    }
}
