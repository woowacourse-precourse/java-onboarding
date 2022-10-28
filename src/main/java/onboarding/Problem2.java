package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public boolean isStringContainingRegularExpression(String string, String regularExpression) {
        return string.matches(String.format("(.*)%s(.*)", regularExpression));
    }
}
