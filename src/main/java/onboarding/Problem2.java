package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

    private static final String STRING_INIT_VALUE = "";
    private static final String DECODE_CRYPTOGRAM_REGEX = "(.)\\1+";
    private static final String REPLACE_CRYPTOGRAM_WORD = "";
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] : ";
    private static final String CRYPTOGRAM_LENGTH_EXCEPTION_MESSAGE = "암호는 길이 1 이상, 1000이하인 문자열만 가능합니다.";
    private static final String CRYPTOGRAM_TYPE_EXCEPTION_MESSAGE = "암호는 알파벳 소문자로만 이루어져야합니다.";
    private static final int MIN_CRYPTOGRAM_LENGTH = 1;
    private static final int MAX_CRYPTOGRAM_LENGTH = 1000;
    private static final String CRYPTOGRAM_TYPE_REGEX = "^[a-z]*$";

    public static String solution(String cryptogram) {
        String decodeResult = STRING_INIT_VALUE;
        validateCryptogram(cryptogram);
        while(!isDecodedSuccess(cryptogram)) {
            cryptogram = decodeString(cryptogram);
        }
        decodeResult = cryptogram;
        return decodeResult;
    }

    private static String decodeString(String cryptogram) {
        return cryptogram.replaceAll(DECODE_CRYPTOGRAM_REGEX, REPLACE_CRYPTOGRAM_WORD);
    }

    private static boolean isDecodedSuccess(String beforeDecodeCryptogram) {
        String afterDecodeCryptogram = decodeString(beforeDecodeCryptogram);
        return beforeDecodeCryptogram.equals(afterDecodeCryptogram);
    }

    private static void validateCryptogram(String cryptogram) {
        if(!validateCryptogramLength(cryptogram)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + CRYPTOGRAM_LENGTH_EXCEPTION_MESSAGE);
        }
        if(!validateCryptogramType(cryptogram)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + CRYPTOGRAM_TYPE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean validateCryptogramLength(String cryptogram) {
        return (cryptogram.length() >= MIN_CRYPTOGRAM_LENGTH && cryptogram.length() <= MAX_CRYPTOGRAM_LENGTH);
    }

    private static boolean validateCryptogramType(String cryptogram) {
        return (Pattern.compile(CRYPTOGRAM_TYPE_REGEX).matcher(cryptogram).matches());
    }
}
