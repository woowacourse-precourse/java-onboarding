package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(hasException(number)){
            return -1;
        }
        
    }

    public static boolean hasException(int number){
        if(number<1 || number>10000)
            return true;
        return false;
    }
}
