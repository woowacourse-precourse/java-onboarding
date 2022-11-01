package onboarding.P2;

public class LetterVerification {

    public static boolean LengthCheck(String cryptogram){
        char [] ch = cryptogram.toCharArray();//길이 1이상 1000이하
        if(ch.length >=1 &&ch.length <= 1000){
            return false;
        }
        return true;
    }
}
