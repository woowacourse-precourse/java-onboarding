package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(hasException(cryptogram)){
            return null;
        }
    }

    public static boolean hasException(String crytogram) {
        if (crytogram.length() < 1 || crytogram.length() > 1000)
            return true;
        else if (crytogram.equals(crytogram.toLowerCase()) == false)
            return true;
        return false;
    }
}
