package onboarding;

import java.util.regex.Pattern;

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

    public static boolean validateCryptogramLength(String cryptogram) {
        boolean isCorrectCryptogramLength = true;
        if(cryptogram.length() < 1 || cryptogram.length() > 1000) {
            isCorrectCryptogramLength = false;
        }
        return isCorrectCryptogramLength;
    }

    public static boolean validateCryptogramType(String cryptogram) {
        boolean isCorrectCryptogramType = false;
        if(Pattern.compile("^[a-z]*$").matcher(cryptogram).matches()) {
            isCorrectCryptogramType = true;
        }
        return isCorrectCryptogramType;
    }
}
