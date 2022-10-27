package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        int startIdx = getOverlabStartIdx(answer);
        while (startIdx != -1) {
            int endIdx = getOverlabEndIdx(answer, startIdx);
            String substr1 = answer.substring(0, startIdx);
            String substr2 = answer.substring(endIdx);
            answer = substr1 + substr2;
            startIdx = getOverlabStartIdx(answer);
        }

        return answer;
    }

    static int getOverlabStartIdx(String s) {
        if (s.length() <= 1) return -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    static int getOverlabEndIdx(String s, int overlabIdx) {
        char base = s.charAt(overlabIdx);
        int endIdx = overlabIdx + 1;
        for (int i = endIdx; i < s.length(); i++) {
            if (base == s.charAt(i)) {
                endIdx += 1;
            } else {
                return endIdx;
            }
        }

        return endIdx;
    }
}