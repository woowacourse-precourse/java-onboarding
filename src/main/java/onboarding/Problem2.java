package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return new Solver2(cryptogram).solve();
    }
}

/**
 * 매번 새 String을 생성하기보다 Blank 문자로 치환하여 속도를 높인 구현
 */
class Solver2 {

    static final char BLANK_MARKER = '-';
    private final String cryptogram;
    private int numberOfRemovedChars = 0;
    private int curIdx = 0;
    private int nextIdx;
    private char[] chars;
    private int totalLength;

    public Solver2(final String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String solve() {
        this.totalLength = cryptogram.length();
        this.chars = cryptogram.toCharArray();

        // 길이가 1 이하면 예외 처리
        if (this.totalLength <= 1) return cryptogram;

        // 종료 조건: 한 바퀴 돌았는데 바뀌는 게 없는 경우
        while (!this.nothingHasChanged()) {
            this.moveIdxToFront();

            if (this.removed()) {
                this.curIdx++;
                continue;
            }

            if (this.twoSubsequentCharsEqual()) {
                this.remove();
            }
            this.curIdx++; // 다음 문자로 이동
        }

        return cleanString();
    }

    /**
     * 문자열을 한 바퀴 모두 검사했는데 아무 문자도 변하지 않은 경우를 반환한다.
     */
    private boolean nothingHasChanged() {
        return this.curIdx >= this.totalLength - 1 && this.numberOfRemovedChars == 0;
    }

    /**
     * 시작 지점으로 포인터를 돌린다.
     */
    private void moveIdxToFront() {
        if (this.curIdx >= this.totalLength - 1) {
            this.curIdx = 0;
            this.numberOfRemovedChars = 0;
        }
    }

    /**
     * 현재 문자가 제거된 상태인지 반환한다.
     */
    private boolean removed() {
        return this.chars[this.curIdx] == BLANK_MARKER;
    }

    /**
     * char[]에서 blank가 아닌 값을 가진 char의 idx를 계산한다.
     */
    private int idxOfNextChar() {
        int idx = this.curIdx + 1;
        for (; idx < this.chars.length; idx++) {
            if (this.chars[idx] != BLANK_MARKER) break;
        }
        return idx;
    }

    /**
     * 연속된 두 문자가 동일한지 비교한다.
     */
    private boolean twoSubsequentCharsEqual() {
        this.nextIdx = this.idxOfNextChar();
        return this.chars[this.curIdx] == this.chars[this.nextIdx];
    }

    /**
     * 연속된 두 문자를 제거하고 idx를 이동한다.
     */
    private void remove() {
        this.chars[this.curIdx] = BLANK_MARKER;
        this.chars[this.nextIdx] = BLANK_MARKER;
        this.numberOfRemovedChars += 2;
        this.curIdx = this.nextIdx; // 루프 아낌 (한 번에 가려면 nextIdx + 1)
    }

    /**
     * Blank 문자가 없는 문자열로 반환한다.
     */
    private String cleanString() {
        return new String(this.chars).replace(BLANK_MARKER + "", "");
    }
}
