package onboarding;
import java.lang.Object; // for pow
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // number is not bigger than 10000
        // number = a * 1000 + b * 100 + c * 10 + d.
        // generallize about a, (a / 3 ) * pow(10, n) + a * 3 * n * pow(10, n-1);
        // exception, if a == 3 or 6 or 9
        // than, ((a - 1) / 3) * pow(10 , n) + a * 3 * n * pow(10, n - 1) + number % pow(10, n);

        // calculate 10000 ~ 10 digit
        for(int exp = 4; exp > 0; exp--){
            // calculate number of digit
            int digit = (int)((number % Math.pow(10, exp + 1)) / Math.pow(10, exp));
            answer += (digit / 3) * Math.pow(10, exp) + digit * 3 * exp * Math.pow(10, exp - 1);
            if((digit == 3) || (digit == 6) || (digit == 9)){ // exception.
                answer += number % Math.pow(10, exp) + 1 - Math.pow(10, exp);
            }
        }
        // calculate at 1 digit
        int digit1 = number % 10;
        answer += digit1 / 3;

        return answer;
    }
}
