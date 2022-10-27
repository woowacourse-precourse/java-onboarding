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

    public static void validateCryptogramLength(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("암호는 길이 1 이상, 1000이하의 문자열입니다.");
        }
    }
}
