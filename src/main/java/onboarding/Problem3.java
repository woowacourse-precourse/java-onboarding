package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int clap(int number){
        int result = 0;
        while(number > 0){
            int digit = number % 10;

            if (digit == 3 || digit == 6 || digit == 9){
                result += 1;
            }

            number /= 10;
        }
        return result;
    }
}
