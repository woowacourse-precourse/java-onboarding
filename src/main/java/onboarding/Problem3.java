package onboarding;

public class Problem3 {

    private static final int[] TARGET_NUMBERS = {3, 6, 9};
    public static boolean isTargetNumber(int number){
        for(int i = 0; i < TARGET_NUMBERS.length; i++){
            if(number == TARGET_NUMBERS[i]){
                return true;
            }
        }
        return false;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
