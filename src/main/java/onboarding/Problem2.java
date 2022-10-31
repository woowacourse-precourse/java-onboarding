package onboarding;

public class Problem2 {
    private static boolean isAllLowerCase(String cryptogram)
    {
        int i = 0;
        int len = cryptogram.length();

        while (i < len && Character.isLowerCase(cryptogram.charAt(i))) {
            i++;
        }
        return (i == len);
    }
    private static boolean isValidLength(String cryptogram)
    {
        int len = cryptogram.length();

        return (0 < len && len < 1001);
    }
    private static boolean isValidCryptogram(String cryptogram)
    {
        return (cryptogram != null && isAllLowerCase(cryptogram) && isValidLength(cryptogram));
    }
    public static String solution(String cryptogram) {
        if (!isValidCryptogram(cryptogram))
            throw (new RuntimeException("유효하지 않은 문자열"));
        return ("");
    }
}
