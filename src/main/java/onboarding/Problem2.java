package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        return deleteRecursive(cryptogram);
    }

    public static Boolean isRepeated(String cryptogram) {

        if(cryptogram.equals(deleteRepeated(cryptogram)))
            return false;
        else
            return true;
    }

    public static String deleteRepeated(String cryptogram) {

        return cryptogram.replaceAll("([a-z])\\1+","");
    }

    public static String deleteRecursive(String cryptogram) {

        String decoding = cryptogram;

        if (!isRepeated(decoding))
            return decoding;

        else {
            decoding = deleteRepeated(decoding);
            return solution(decoding);
        }
    }

}