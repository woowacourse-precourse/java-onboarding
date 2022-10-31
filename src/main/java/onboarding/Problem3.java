package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countClapping(number);
    }

    public static int countClapping(int number){
        int count = 0;
        for(int i = 1; i <= number; i++){
            count += count369DigitNumber(i);
        }

        return count;
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
