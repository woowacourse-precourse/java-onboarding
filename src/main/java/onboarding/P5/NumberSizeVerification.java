package onboarding.P5;

public class NumberSizeVerification {

    public static boolean NumberCheck(int money){
        if(1 <= money & money <= 1000000){
            return true;
        }else{
            return false;
        }
    }
}
