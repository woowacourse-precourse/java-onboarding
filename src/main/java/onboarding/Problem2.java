package onboarding;

public class Problem2 {
    private static char rememberChar = '\0';

    public static String solution(String cryptogram) {
        while (true) {
            String duplicateChars = getDuplicateChars(cryptogram);
            cryptogram = cryptogram.replace(duplicateChars, "");
            if(isNoDuplicate(cryptogram)) {
                return cryptogram;
            }
        }
    }

    private static String getDuplicateChars(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<cryptogram.length(); i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                rememberChar = cryptogram.charAt(i-1);
                sb.append(cryptogram.charAt(i-1));
            }
            else {
                if(rememberChar == cryptogram.charAt(i-1)) {
                    sb.append(cryptogram.charAt(i-1));
                }
                rememberChar = '\0';
            }

            if(isLastCharDuplicate(cryptogram, i)) {
                sb.append(cryptogram.charAt(i));
            }
        }
        return sb.toString();
    }

    private static boolean isLastCharDuplicate(String cryptogram, int i) {
        if(i == cryptogram.length()-1) {
            return cryptogram.charAt(i) == rememberChar;
        }
        return false;
    }

    private static boolean isNoDuplicate(String cryptogram) {
        for(int i=1; i<cryptogram.length(); i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }
}