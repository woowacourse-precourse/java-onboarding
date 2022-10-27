package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return "a";
    }

    private static boolean isSolitary(String cryptogram, int index) {
        if (index == 0)
            return cryptogram.charAt(index) != cryptogram.charAt(index + 1);
        if (index == cryptogram.length() - 1)
            return cryptogram.charAt(index) != cryptogram.charAt(index - 1);
        if (cryptogram.charAt(index) != cryptogram.charAt(index-1)
                && cryptogram.charAt(index) != cryptogram.charAt(index + 1))
            return true;
        return false;
    }

}
