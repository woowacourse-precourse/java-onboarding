package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer answer = new StringBuffer(cryptogram);

        while (true) {
            int sameIdx = getSameIdx(answer);

            if (sameIdx == -1) {
                break;
            }
            answer = removeSame(answer, sameIdx);
        }

        return answer.toString();
    }

    private static int getSameIdx(StringBuffer string) {
        char[] charArray = string.toString().toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private static StringBuffer removeSame(StringBuffer origin, int idx) {
        origin.delete(idx, idx + 2);
        return origin;
    }

}