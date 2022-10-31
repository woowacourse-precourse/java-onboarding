package onboarding;

public class Problem2 {
    private static boolean isDuplication(String str) {
        if (str == "")
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
        while (isDuplication(str)) {
            String newStr = "";
            char tmp = str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (tmp != cur) {
                    newStr += tmp;
                    tmp = cur;
                }
                else {
                    if (i != str.length() - 1)
                        tmp = str.charAt(++i);
                }
            }
            if (tmp != str.charAt(str.length() - 2))
                newStr += tmp;
            str = newStr;
        }
        return str;
    }
}
