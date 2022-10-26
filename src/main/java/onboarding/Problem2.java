package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static int hasDuplicate(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                return i;
        }
        return -1;
    }

    static String decode(String cryptogram) {
        int start = hasDuplicate(cryptogram);
        if (start == -1)
            return cryptogram;

        for (int end = start + 1; end < cryptogram.length(); end++) {

            if (cryptogram.charAt(end) != cryptogram.charAt(start) || end == cryptogram.length() - 1) {
                cryptogram = cryptogram.replace(cryptogram.substring(start, end), "");
                break;
            }
        }
        return decode(cryptogram);
    }

}
