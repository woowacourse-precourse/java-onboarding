package onboarding;

public class Problem4 {
    public static String solution(String word) {

        Word input = new Word(word);

        input.reverseWord();

        return input.getWord();
    }
}

class Word {

    private String word;

    public Word(String word) {
        validateLength(word);
        this.word = word;
    }

    private void validateLength(String word) {
        if(word.length() < 1) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
        if(word.length() > 1000) {
            throw new IllegalArgumentException("1000자 이상은 입력할 수 없습니다.");
        }
    }

    public String getWord() {
        return this.word;
    }

    public void reverseWord() {
        StringBuilder sb = new StringBuilder();

        char curr, change;
        int n;
        for (int i = 0; i < word.length(); i++) {
            curr = word.charAt(i);
            if (curr == ' ') {
                // 띄어쓰기 일 때
                sb.append(curr);
            } else if (curr >= 'a') {
                // 소문자일 때
                n = curr - 'a';
                change = (char) ('z' - n);
                sb.append(change);
            } else {
                // 소문자도 띄어쓰기도 아닐 떄
                n = curr - 'A';
                change = (char) ('Z' - n);
                sb.append(change);
            }
        }
        this.word = sb.toString();
    }
}
