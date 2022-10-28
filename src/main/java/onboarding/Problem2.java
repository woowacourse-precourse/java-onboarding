package onboarding;

public class Problem2 {
    private static final String EXCEPTION = "EXCEPTION";
    public static String solution(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000 || !cryptogram.matches("^[a-z]*$"))
            return EXCEPTION;
        return decode(cryptogram);
    }

    private static String decode(String cryptogram) {
        String answer = cryptogram.replaceAll("([a-z])\\1","");
        if (answer.matches("^[a-z]*([a-z])\\1[a-z]*$"))
            return decode(answer);
        return answer;
    }
}
