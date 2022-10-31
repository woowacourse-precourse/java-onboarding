package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(checkException(number)){
            throw new IllegalArgumentException();
        }
        return answer;
    }
    public static boolean checkException(int number){
        if(checkNumber(number)){
            return true;
        }

        return false;
    }
    public static boolean checkNumber(int number){
        return number < 1 || number > 1000;
    }
}
