package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(Check(number)){

        }
        throw new IllegalArgumentException("잘못된 입력값");
    }

    private static boolean Check(int number){
        if(number > 0 && number <10000) return true;
        return false;

    }
}
