package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (isDuplication(cryptogram)) {
            cryptogram = removeDuplication(cryptogram);
        }

        return cryptogram;
    }

    public static boolean isDuplication(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return true;
        }
        return false;
    }

    public static String removeDuplication(String str) {
        StringBuilder result = new StringBuilder();

        str += " ";
        char preChar = ' ';

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                preChar = str.charAt(i);
                i++;
                continue;
            } else if (str.charAt(i) == preChar) {
                preChar = str.charAt(i);
                continue;
            }
            preChar = str.charAt(i);
            result.append(str.charAt(i));
        }

        return result.toString();
    }
}
