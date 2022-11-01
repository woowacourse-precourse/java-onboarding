package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length() == 1)
            return cryptogram;
        return decode(cryptogram);
    }

    public static String decode(String str) {
        String before = str;
        String after = removeDuplication(before);
        while (after.length() > 1 && !after.equals(before)) {
            before = after;
            after = removeDuplication(before);
        }
        return after;
    }

    public static String removeDuplication(String str) {
        String result = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1))
                result += String.valueOf(str.charAt(i));
            else
                i += duplicationCount(str, i);
        }
        if (str.length() > 1 && str.charAt(str.length() - 2) != str.charAt(str.length() - 1))
            result += String.valueOf(str.charAt(str.length() - 1));
        return result;
    }

    public static int duplicationCount(String str, int start) {
        int cnt = 0;

        while (start < str.length() - 1 && str.charAt(start) == str.charAt(start + 1)) {
            cnt += 1;
            start += 1;
        }
        return cnt;
    }
}
