package onboarding;

public class Word {

    private String word;

    public Word(String word) {
        isValidWord(word);
        
        this.word = word;
    }

    public String conversion() {
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            str += converseLetter(word.charAt(i));
        }

        return str;
    }

    private char converseLetter(char c) {
        if (isLower(c))
            return (char) ('a' + ('z' - c));

        if (isUpper(c))
            return (char) ('A' + ('Z' - c));

        return c;
    }

    private boolean isLower(char c) {
        if (c >= 'a' && c <= 'z')
            return true;

        return false;
    }

    private boolean isUpper(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;

        return false;
    }

    private void isValidWord(String word) {
        if (word.length() < 1 || word.length() > 1000)
            throw new IllegalArgumentException("문자의 길이는 1 이상 1000 이하여야 합니다.");
    }

}
