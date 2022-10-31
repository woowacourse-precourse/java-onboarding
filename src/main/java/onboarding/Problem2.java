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

    public static boolean isException(String cryptogram){
        if(isInRange(cryptogram) && isLowerCase(cryptogram))
            return true;
        return false;
    }

    public static String deleteDuplicate(String cryptogram, Integer startIdx, Integer endIdx){
        String Duplicate = cryptogram.substring(startIdx, endIdx+1);
        return cryptogram.replaceAll(Duplicate, "");
    }
}
