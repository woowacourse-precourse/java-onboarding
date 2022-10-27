package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        return answer;
    }

    static int getOverlabStartIdx(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    static String getOverlabEndIdx(String s, int overlabIdx) {
        int endIdx = overlabIdx + 1;
        for (int i = overlabIdx + 2; i < s.length() - 1; i++) {
            if (i > s.length() - 1)
                return endIdx;

            if (s.charAt(i) == s.charAt(i + 1)) {
                endIdx += 1;
            }
        }

        return endIdx;
    }
}