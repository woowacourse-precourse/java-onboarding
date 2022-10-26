package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicated(cryptogram);
    }

    public static String removeDuplicated(String target) {
        String result = target.replaceAll("(.)\\1+", "");
        if (!target.equals(result)) {
            result = removeDuplicated(result);
        }
        return result;
    }
}
