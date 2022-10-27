package onboarding;

public class Problem3 {
    private static final int[] TARGET_NUMBERS = {3, 6, 9};
    private static final int MAX_DIGITS = 5;
    public static boolean isTargetNumber(int number){
        for(int i = 0; i < TARGET_NUMBERS.length; i++){
            if(number == TARGET_NUMBERS[i]){
                return true;
            }
        }
        return false;
    }

    public static int countNumberOfClaps(int number){
        int count = 0;
        int[] digits = getDigits(number);
        for(int i = 0; i < digits.length; i++){
            if(isTargetNumber(digits[i])){
                count++;
            }
        }
        return count;
    }

    public static int[] getDigits(int number){
        int[] digits = new int[MAX_DIGITS];
        int position = MAX_DIGITS - 1;
        while(position > 0){
            int digit = number % 10;
            digits[position] = digit;
            position--;
            number /= 10;
        }
        return digits;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer = answer + countNumberOfClaps(i);
        }
        return answer;
    }
}
