package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        answer = decrypto(cryptogram);
        return answer;
    }

    public static String decrypto(String string) {
        String copy = string;
        for (int i=0; i<string.length()-1; i++) {
            if (isCharsDuplicatedInGivenIdx(string, i)) {
                string = getTwoCharsDeletedInGivenIdx(string, i);
            }
        }
        if (string.equals(copy)) {
            return string;
        }
        string = decrypto(string);
        return string;
    }

    public static boolean isCharsDuplicatedInGivenIdx(String string, int idx) {
        if (string.charAt(idx) == string.charAt(idx+1)) {
            return true;
        }
        return false;
    }

    public static String getTwoCharsDeletedInGivenIdx(String string, int idx) {
        String prefix = string.substring(0, idx);
        String suffix = string.substring(idx+2, string.length());
        return prefix + suffix;
    }
}
