package onboarding;

public class Problem2 {

    public String regularExpressionOfConsecutiveDuplicateCharactersForMatch = "(.*)(\\w)\\2{1,}(.*)";
    public String regularExpressionOfConsecutiveDuplicateCharacters = "(\\w)\\1{1,}";
    public boolean isStringContainingRegularExpression(String string, String regularExpression) {
        return string.matches(regularExpression);
    }

    public String deleteStringByRegularExpression(String string, String regularExpression) {
        return string.replaceAll(regularExpression, "");
    }
    public static String solution(String cryptogram) {

        Problem2 problem2 = new Problem2();

        while (problem2.isStringContainingRegularExpression(cryptogram, problem2.regularExpressionOfConsecutiveDuplicateCharactersForMatch)) {
            cryptogram = problem2.deleteStringByRegularExpression(cryptogram, problem2.regularExpressionOfConsecutiveDuplicateCharacters);
        }
        return cryptogram;
    }
}
