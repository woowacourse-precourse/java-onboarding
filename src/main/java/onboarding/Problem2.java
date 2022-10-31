package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean isInRange(String cryptogram) {
        int length = cryptogram.length();
        if (length >= 1 && length <= 400)
            return true;

        return false;
    }

    public static boolean isLowerCase(String cryptogram){
        String originCryptogram = cryptogram;
        String transCryptogram = cryptogram.toLowerCase();

        if(originCryptogram.equals(transCryptogram))
            return true;

        return false;
    }
}
