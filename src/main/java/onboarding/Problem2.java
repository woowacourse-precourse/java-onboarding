package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String decodeResult = "answer";
        while(!isDecodedSuccess(cryptogram)) {
            cryptogram = decodeString(cryptogram);
        }
        decodeResult = cryptogram;
        return decodeResult;
    }

    public static String decodeString(String cryptogram) {
        return cryptogram.replaceAll("(.)\\1+", "");
    }

    public static boolean isDecodedSuccess(String beforeDecodeCryptogram) {
        String afterDecodeCryptogram = decodeString(beforeDecodeCryptogram);
        return beforeDecodeCryptogram.equals(afterDecodeCryptogram);
    }
}
