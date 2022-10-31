package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        final char REMOVED = '-';
        char[] chars = cryptogram.toCharArray();
        final int totalLength = cryptogram.length();
        int numberOfRemovedChars = 0;
        int curIdx = 1;

        // 길이가 1이면 예외 처리
        if (totalLength == 1) return cryptogram;

        while (true) {
            // 종료 조건: 한 바퀴 돌았는데 바뀌는 게 없는 경우
            if (curIdx >= totalLength - 1) { // 최댓값
                if (numberOfRemovedChars == 0)
                    break;

                curIdx = 0;
                numberOfRemovedChars = 0;
            }

            // 제거 대상이면 다음 문자로 이동
            if (chars[curIdx] == REMOVED) {
                curIdx++;
                continue;
            }

            /*
                noommn
                n--mmn
                n----n
                n----n
             */
            int nextIdx = getNextNormalCharIdx(chars, curIdx);
            if (chars[curIdx] == chars[nextIdx]) {
                chars[curIdx] = REMOVED;
                chars[nextIdx] = REMOVED;
                curIdx = nextIdx; // 루프 아낌 (한 번에 가려면 nextIdx + 1)
                numberOfRemovedChars += 2;
            }
            curIdx++; // 다음 문자로 이동

            System.out.println(new String(chars));
        }

        return new String(chars).replaceAll("-", "");
    }

    private static int getNextNormalCharIdx(char[] chars, int curIdx) {
        int i = curIdx + 1;
        for (; i < chars.length; i++) {
            if (chars[i] != '-')
                break;
        }
        return i;
    }
}
