package onboarding.problem2;

public class Limiter {

    //제한하기 : 길이가1이상1000이하
    public static String limitLength(String cryptogram){

        if(  cryptogram.length() <= 1 && cryptogram.length() >= 1000) {
            return "길이 제한 범위를 벗어났습니다.";
        }

        return cryptogram;
    }
}
