package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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
    private char[] toArray() {
        return letters.toCharArray();
    }
}

class Result {
    private char[] wordArray;
    private StringBuilder sb;

    public Result(char[] wordArray) {
        this.wordArray = wordArray;
        this.sb=new StringBuilder();
    }


    public char changeWordByRule(){
        for(int wordChar:wordArray){
            if(!Character.isAlphabetic(wordChar)){
                return ' ';
            }
            if(isAlphaLower(wordChar)){
                char replaceChar= (char)(155-wordChar);
                return toUpperCase(replaceChar);
            }
            if(isAlphaUpper(wordChar)){
                char replaceChar= (char)(219-wordChar);
                return toLowerCase(replaceChar);
            }
        }
    }

    public boolean isAlphaUpper(int wordChar){
        if(wordChar>='A'&&wordChar<='Z'){
            return true;
        }
        return false;
    }

    public boolean isAlphaLower(int wordChar){
        if(wordChar>='a'&&wordChar<='z'){
            return true;
        }
        return false;
    }

    public char toUpperCase(char wordChar){
        return Character.toUpperCase(wordChar);
    }

    public char toLowerCase(char wordChar){
        return Character.toLowerCase(wordChar);
    }

}


