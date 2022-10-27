package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypto(cryptogram);
        return answer;
    }

    public static String decrypto(String string) {
        String copy = string;
        for (int i=0; i<string.length()-1; i++) {
            if (isCharsDuplicatedInGivenIdx(string, i)) {
                string = getCharsDeletedInGivenIdx(string, i);
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

    public static String getCharsDeletedInGivenIdx(String string, int idx) {
        return string;
    }
}
