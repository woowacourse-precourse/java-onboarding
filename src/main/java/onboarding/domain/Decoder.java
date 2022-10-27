package onboarding.domain;

public class Decoder {
    public static final String REGEX_DUPLICATE_CHARACTER = "(([a-z])\\2+)";
    public static final String BLANK = "";

    private final String decodeResult;

    public Decoder(String cryptogram) {
        this.decodeResult = decode(cryptogram);
    }

    private String decode(String cryptogram) {
        String previousDecodeResult = "";
        String decodeResult = cryptogram;
        while (hasDuplicateCharacters(previousDecodeResult, decodeResult)) {
            previousDecodeResult = decodeResult;
            decodeResult = removeDuplicateCharacters(previousDecodeResult);
        }
        return decodeResult;
    }

    private static boolean hasDuplicateCharacters(String previousDecodeResult, String decodeResult) {
        return !previousDecodeResult.equals(decodeResult);
    }

    private String removeDuplicateCharacters(String previousDecodeResult) {
        return previousDecodeResult.replaceAll(REGEX_DUPLICATE_CHARACTER, BLANK);
    }

    public String getDecodeResult() {
        return decodeResult;
    }
}
