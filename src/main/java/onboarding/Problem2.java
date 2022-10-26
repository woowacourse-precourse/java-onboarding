package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    public static String decode(String str) {
        while (str.length() > 1) {
            String newStr = deleteDuplicateChar(str);
            if (str.equals(newStr)) {
                break;
            }
            str = newStr;
        }
        return str;
    }

    private static String deleteDuplicateChar(String str) {
        StringBuilder sb = new StringBuilder();

        if (str.charAt(0) != str.charAt(1)) {
            sb.append(str.charAt(0));
        }
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i - 1) != str.charAt(i) &&
                    str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
            }
        }
        if (str.charAt(str.length() - 2) != str.charAt(str.length() - 1)) {
            sb.append(str.charAt(str.length() - 1));
        }
        return sb.toString();
    }
}
