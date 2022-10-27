package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(!checkValidation(number)){
            return -1;
        }
        return answer;
    }

    private static boolean checkValidation(int number){
        if(1<number && number<10000){
            return true;
        }
        return false;
    }

}
