package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = word;
        Game4 game4 = new Game4();
        return game4.getResult(word);
    }
}

class Word {
    private String letters;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String NOT_ALLOWED_UNDER_MIN_LENGTH = "주어진 word의 길이는 1이상입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_LENGTH = "주어진 word의 길이는 1000이하입니다.";

    public Word(String letters) {
        this.letters = letters;
        validateLength();
    }

    private void validateLength() {
        if (letters.length() < MIN_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_LENGTH);
        }

        if (letters.length() > MAX_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_LENGTH);
        }
    }

    public char[] toArray() {
        return letters.toCharArray();
    }
}

class Result {
    private char[] wordArray;
    private StringBuilder sb;
    private static final int FIND_UPPER_CASE_REPLACE = 155;
    private static final int FIND_LOWER_CASE_REPLACE = 219;

    public Result(char[] wordArray) {
        this.wordArray = wordArray;
        this.sb = new StringBuilder();
    }

    private char changeWordByRule(int wordChar) {
        if (!Character.isAlphabetic(wordChar)) {
            return ' ';
        }
        if (isAlphaLower(wordChar)) {
            char replaceChar = (char) (FIND_LOWER_CASE_REPLACE - wordChar);
            return replaceChar;
        }
        char replaceChar = (char) (FIND_UPPER_CASE_REPLACE - wordChar);
        return replaceChar;
    }

    public String reverse() {
        for (char wordChar : wordArray) {
            sb.append(changeWordByRule(wordChar));
        }
        return sb.toString();
    }

    private boolean isAlphaLower(int wordChar) {
        if (wordChar >= 'a' && wordChar <= 'z') {
            return true;
        }
        return false;
    }
}

class Game4 {
    private Word wordObject;
    private Result result;

    public String getResult(String word) {
        wordObject = new Word(word);
        result = new Result(wordObject.toArray());
        return result.reverse();
    }
}


