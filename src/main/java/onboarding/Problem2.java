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

    public static void validateCryptogram(String cryptogram) {
        if(!validateCryptogramLength(cryptogram)) {
            throw new IllegalArgumentException("[ERROR] : 암호는 길이 1 이상, 1000이하인 문자열만 가능합니다.");
        }
        if(!validateCryptogramType(cryptogram)) {
            throw new IllegalArgumentException("[ERROR] : 암호는 알파벳 소문자로만 이루어져야합니다.");
        }
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
