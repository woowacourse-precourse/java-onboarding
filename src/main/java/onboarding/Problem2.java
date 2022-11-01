package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean canGoNext = true;
        StringBuilder answer = new StringBuilder(cryptogram);
        while (canGoNext) {
            canGoNext = false;
            int idx = 0;
            while (idx < answer.length()) {
                char previous = answer.charAt(idx);
                int idxAfterSearching = searchContinuousLetter(answer, previous, idx);
                if (isContinuous(idx, idxAfterSearching)) {
                    answer.delete(idx, idxAfterSearching);
                    canGoNext = true;
                    continue;
                }
                idx++;
            }
        }
        return answer.toString();
    }

    private static int searchContinuousLetter(StringBuilder answer, char previous, int idx) {
        char current = answer.charAt(idx);
        while (previous == current) {
            if (++idx == answer.length()) {
                break;
            }
            current = answer.charAt(idx);
        }
        return idx;
    }

    private static boolean isContinuous(int idx, int cnt) {
        return cnt - idx != 1;
    }
}
