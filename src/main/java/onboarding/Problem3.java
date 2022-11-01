package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int exponent = 0;
        int left = 0;
        while (number > 2){
            int remainder = number % 10;
            number /= 10;
            answer += (number * 3) * Math.pow(10, exponent);
            if (remainder >= 3){
                answer += (remainder - 1)/3 * Math.pow(10, exponent);
                if (remainder % 3 == 0){
                    answer += left + 1;
                }
            }
            left += remainder * Math.pow(10, exponent);
            exponent += 1;
        }
        return answer;
    }
}
