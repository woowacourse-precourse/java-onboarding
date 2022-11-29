package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int len = cryptogram.length();

        if (len <= 2) {
            return confirmShortStr(cryptogram, len);
        }
        return UniqueStr.findUniqueStr(cryptogram, len - 1);
    }

    private static String confirmShortStr(String str, int len) {
        if (len == 2 && str.charAt(0) == str.charAt(1)) {
            return "";
        }
        return str;
    }

    private static class UniqueStr {
        private static int cur;
        private static int next;
        private static StringBuilder preStr;

        private static String findUniqueStr(String str, int lastIdx) {
            cur = 0;
            next = 1;
            preStr = new StringBuilder();

            while (lastIdx >= cur) {
                movePointer(str, lastIdx);
                addUniqueChar(str, lastIdx);
                cur++;
                next++;
            }
            return preStr.toString();
        }

        private static void movePointer(String str, int lastIdx) {
            while (lastIdx > cur && str.charAt(cur) == str.charAt(next)) {
                compareCurNext(str, lastIdx);
            }
        }

        private static void compareCurNext(String str, int lastIdx) {
            char curChar = str.charAt(cur);
            while (next <= lastIdx && curChar == str.charAt(next)) {
                next++;
            }
            cur = next;
            next = cur + 1;
        }

        private static void addUniqueChar(String str, int lastIdx) {
            if (comparePreCur(str, lastIdx) && cur <= lastIdx) {
                preStr.append(str.charAt(cur));
            }
        }

        private static boolean comparePreCur(String str, int lastIdx) {
            int idx = preStr.length() - 1;

            while (idx >= 0 && preStr.charAt(idx) == str.charAt(cur)) {
                preStr.deleteCharAt(idx);
                cur++;
                next++;
                idx = preStr.length() - 1;

                if (cur > lastIdx) {
                    return false;
                }
            }
            return true;
        }
    }

}