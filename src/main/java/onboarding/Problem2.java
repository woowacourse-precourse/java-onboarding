package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String decoding(String code) {
        boolean same = false;
        boolean hasChanged = false;
        String decodedStr = "";
        if (code.length() <= 1)
            return code;
        for (int i = 0; i < code.length() - 1; i++) {
            if (code.charAt(i) == code.charAt(i + 1)) {
                same = true;
                hasChanged = true;
            }
            else {
                if (same) {
                    same = false;
                    continue;
                }
                else
                    decodedStr += code.charAt(i);
                same = false;
            }
        }
        if (!same) {
            decodedStr += code.charAt(code.length() - 1);
        }
        if (hasChanged)
            return decoding(decodedStr);
        else
            return decodedStr;
    }

}
