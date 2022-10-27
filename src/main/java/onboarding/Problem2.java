package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean deleted = true;
        cryptogram = cryptogram.toLowerCase();

        if(validation(cryptogram)){
            return "";
        }

        do{

        }while(deleted);

        return cryptogram;
    }

    private static boolean validation(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000){
            return true;
        }

        return false;
    }
}
