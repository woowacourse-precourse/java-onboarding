package onboarding;

public class Problem3 {
    public static String numberString;
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int count369InDigitNumber(int digitNumber) {
        if(digitNumber>=9) {
            return 3;
        }
        if(digitNumber>=6) {
            return 2;
        }
        if(digitNumber>=3){
            return 1;
        }
        return 0;
    }
}
