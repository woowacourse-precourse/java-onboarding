package onboarding;

public class Problem2 {
    private static boolean isDuplication(String str) {
        if (str.equals(""))
            return false;

        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (tmp == cur) {
                return true;
            }
            tmp = cur;
        }
        return false;
    }

    public static String solution(String cryptogram) {
        while (isDuplication(cryptogram)) {
            String newStr = "";
            char tmp = cryptogram.charAt(0);
            for (int i = 1; i < cryptogram.length(); i++) {
                char cur = cryptogram.charAt(i);
                if (tmp != cur) {
                    newStr += tmp;
                    tmp = cur;
                }
                else {
                    if (i != cryptogram.length() - 1)
                        tmp = cryptogram.charAt(++i);
                }
            }
            if (tmp != cryptogram.charAt(cryptogram.length() - 2))
                newStr += tmp;
            cryptogram = newStr;
        }
        return cryptogram;
    }
}
