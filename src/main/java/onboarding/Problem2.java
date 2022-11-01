package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String resultString = cryptogram;

        // 연속되는 두글자가 있다면 치환한다.
        while (isThereMatch(resultString)) {
            resultString = replaceMethod(resultString);
        }

        return resultString;
    }

    /**
     * 연속되는 두글자가 있는지 확인한다.
     * @param string 주어진 문자열
     * @return 참 거짓
     */
    private static Boolean isThereMatch(String string) {
        Boolean result = string.matches(".*([a-zA-Z])\\1+.*");
        return result;
    }

    /**
     * 연속되는 두글자를 제거한다.
     * @param string 주어진 문자열
     * @return 제거한 문자열
     */
    private static String replaceMethod(String string) {
        String result = string.replaceAll("([a-zA-Z])\\1+", "");
        return result;
    }
}
