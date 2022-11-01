package onboarding;

public class Problem2 {
    private static final String RESTRICTIONS = "word length error or character error";
    public static String solution(String cryptogram) {
        return cryptogram.length() < 1 || cryptogram.length() > 1000 || !cryptogram.matches("^[a-z]*$")
            ? RESTRICTIONS
            : decode(cryptogram);
    }

    private static String decode(String cryptogram) {
        String answer = cryptogram.replaceAll("([a-z])\\1+","");
        return answer.matches("^[a-z]*([a-z])\\1[a-z]*$")
                ? decode(answer)
                : answer;
    }
}
