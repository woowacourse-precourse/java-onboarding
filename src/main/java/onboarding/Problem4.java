package onboarding;

public class Problem4 {

    public static String solution(String word) {
        return new Solver4(word).solve();
    }
}

class Solver4 {

    private final String word;
    private int curIdx;
    private char cur;

    public Solver4(final String word) {
        this.word = word;
        this.curIdx = 0;
        this.cur = this.word.charAt(0);
    }

    public String solve() {
        StringBuilder builder = new StringBuilder();
        while (!this.reachedEndOfWord()) {
            try {
                this.assertCharAlphabetical();
                builder.append(this.reverseOfCur());
            } catch (Exception e) {
                builder.append(this.cur);
            } finally {
                this.moveToNext();
            }
        }
        return builder.toString();
    }

    private void assertCharAlphabetical() {
        if (!this.upperCase() && !this.lowerCase()) {
            throw new IllegalArgumentException("Input is not alphabetical");
        }
    }

    private boolean upperCase() {
        return this.cur >= 'A' && this.cur <= 'Z';
    }

    private boolean lowerCase() {
        return this.cur >= 'a' && this.cur <= 'z';
    }

    private boolean reachedEndOfWord() {
        return this.curIdx == this.word.length();
    }

    private char reverseOfCur() {
        if (this.upperCase()) {
            return (char) ('Z' - (this.cur - 'A'));
        } else {
            return (char) ('z' - (this.cur - 'a'));
        }
    }

    /**
     * 문자열에서 다음 문자를 할당한다.
     */
    private void moveToNext() {
        this.curIdx++;
        if (!this.reachedEndOfWord()) {
            this.cur = this.word.charAt(this.curIdx);
        }
    }
}
