package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        Problem2 p2 = new Problem2();

        while (p2.isOverlap(answer)) {
            boolean[] overlapPosition = p2.getOverlapPosition(answer);
            answer = p2.rebuild(answer, overlapPosition);
        }

        return answer;
    }

    private boolean isOverlap(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean[] getOverlapPosition(String str) {
        boolean[] overlap = new boolean[str.length()];
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                overlap[i]  = true;
                overlap[i + 1] = true;
            }
        }
        return overlap;
    }

    private String rebuild(String str, boolean[] overlap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < overlap.length; i++) {
            if (!overlap[i]) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
