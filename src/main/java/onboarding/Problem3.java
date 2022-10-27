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
        int[] digits = new int[MAX_DIGITS];
        //digits = getDigits(number);
        for(int i = 0; i < MAX_DIGITS; i++){
            if(isTargetNumber(digits[i])){
                count++;
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer = answer + countNumberOfClaps(i);
        }
        return answer;
    }
}
