package onboarding.domain.problem4;


public class Word {
    private String word;
    public Word(String word) {
        if (outOfRange(word))
            throw new IllegalArgumentException("1이상 1000이하의 문자열을 입력해주세요.");
        this.word = word;
    }

    private boolean outOfRange(String word) {
        return word.length() > 1000 && word.length() <1;
    }

    public int length() {
        return word.length();
    }

    public char get(int i) {
        return word.charAt(i);
    }
}
