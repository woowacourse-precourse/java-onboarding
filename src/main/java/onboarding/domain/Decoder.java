package onboarding.domain;

public class Decoder {
    public static final String REGEX_DUPLICATE_CHARACTER = "(([a-zA-Z])\\2{1,2})";
    public static final String BLANK = "";

    private final String decodeResult;

    public Decoder(String cryptogram) {
        this.decodeResult = removeDuplicateCharacters(cryptogram);
    }

    private String removeDuplicateCharacters(String previousDecodeResult) {
        return previousDecodeResult.replaceAll(REGEX_DUPLICATE_CHARACTER, BLANK);
    }

    public String getDecodeResult() {
        return decodeResult;
    }
}
