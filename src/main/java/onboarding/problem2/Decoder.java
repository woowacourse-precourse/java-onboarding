package onboarding.problem2;

public class Decoder {

    private String regularExpressionOfConsecutiveDuplicateCharactersForMatch = "(.*)(\\w)\\2{1,}(.*)";
    private String regularExpressionOfConsecutiveDuplicateCharacters = "(\\w)\\1{1,}";

    public boolean isStringContainingRegularExpression(String string, String regularExpression) {
        return string.matches(regularExpression);
    }

    public String deleteStringByRegularExpression(String string, String regularExpression) {
        return string.replaceAll(regularExpression, "");
    }

    public String decodeCryptogram(String cryptogram) {
        while (isStringContainingRegularExpression(cryptogram, regularExpressionOfConsecutiveDuplicateCharactersForMatch)) {
            cryptogram = deleteStringByRegularExpression(cryptogram, regularExpressionOfConsecutiveDuplicateCharacters);
        }
        return cryptogram;
    }
}
