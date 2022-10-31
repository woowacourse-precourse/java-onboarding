package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeOverlay(cryptogram);
    }

    static String removeOverlay(String s) {
        int overlayIndex = frontIndex(s);
        if (overlayIndex == -1) return s;
        int lastIndex = overlayIndex + getLength(s, s.charAt(overlayIndex), overlayIndex);
        if (lastIndex == 0) return "";
        return removeOverlay(s.substring(0, overlayIndex)
                    + s.substring(lastIndex+1));
    }

    static int frontIndex(String s) {
        int index = -1;
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                return i;
            }
        }
        return index;
    }

    static int getLength(String s, Character c, int index) {
        if (c == -1) return 0;
        for (int i=index;i<s.length();i++) {
            if (s.charAt(i) != c) {
                return i - index - 1;
            }
        }
        return 0;
    }
}
