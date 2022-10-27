package onboarding;

public class Problem2 {
    private final static int limit = 1000;
    public static String solution(String cryptogram) {
        if (cryptogram == null) {
            throw new IllegalArgumentException("매개변수를 null 될수 없다.");
        }
        if (cryptogram.length() > limit) {
            throw new IllegalArgumentException("매개변수는 1000를 초과해서는 안된다.");
        }


        String answer = "answer";
        return answer;
    }


}
