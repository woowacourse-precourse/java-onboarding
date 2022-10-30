package onboarding.P3;

public class NumberVerification {
    public static boolean NumberCheck(int number){
        if(1 <= number || number >= 10000){
            return true;
        }else{
            return false;
        }
    }
}
