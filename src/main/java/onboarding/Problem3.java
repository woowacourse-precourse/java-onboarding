package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    public static int count369DigitNumber(int x){
        int count = 0;
        for(int digit; x != 0; x /= 10){
            digit = x % 10;
            if(digit == 3 || digit == 6 || digit == 9) {
                count++;
            }
        }

        return count;
    }
}
