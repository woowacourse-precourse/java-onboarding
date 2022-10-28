package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int beforeLength = 0;
        while (beforeLength != cryptogram.length()) {
            beforeLength = cryptogram.length();
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    cryptogram = removeRepeatedChar(cryptogram, i);
                }
            }
        }
        return cryptogram;
    }
    public static String removeRepeatedChar(String cryptogram, int starting) {
        StringBuilder ret = new StringBuilder();
        ret.append(cryptogram);
        int i = starting;
        for (; i < ret.length() - 1; i++) {
            if (ret.charAt(i) != ret.charAt(i + 1)) {
                break;
            }
        }
        ret.delete(starting, i + 1);
        return ret.toString();
    }
}
