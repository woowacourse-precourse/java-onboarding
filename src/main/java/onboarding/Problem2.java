package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder str = new StringBuilder(cryptogram);

        while (isSameChar(str)) {
            deleteChar(str);
        }
        return deleteChar(str).toString();
    }

    public static boolean isSameChar(StringBuilder str) {
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static StringBuilder deleteChar(StringBuilder str) {
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                str.delete(i, i+2);
                i--;
            }
        }
        return str;
    }
}
