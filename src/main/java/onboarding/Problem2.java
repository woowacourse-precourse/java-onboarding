package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String resultString = cryptogram;
        while (isThereMatch(resultString) == true) {
            resultString = replaceMethod(resultString);
        }
        return resultString;
    }

    private static Boolean isThereMatch(String string) {
        Boolean result = string.matches(".*([a-zA-Z])\\1+.*");
        return result;
    }

    private static String replaceMethod(String string) {
        String result = string.replaceAll("([a-zA-Z])\\1+", "");
        return result;
    }
}
