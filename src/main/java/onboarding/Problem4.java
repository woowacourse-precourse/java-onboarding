package onboarding;

/**
 * Frog
 * <p>
 * 1. listen(String word) = 청개구리가 문자열을 듣는다.
 * 2. speak() = 들은 단어를 모두 반대로 바꾸어 반환한다.
 * 3. change_word() = 들은 문자열을 바꿔서 반환한다.
 * 4. change_character(char c) = c를 알맞게 바꾸어 반환
 * 5. is_uppercase(char c) = 현재 문자가 대문자인지 반환
 * 6. is_lowercase(char c) = 현재 문자가 소문자인지 반환
 */

public class Problem4 {
    public static String solution(String word) {
        Frog frog = new Frog();
        frog.listen(word);
        return frog.speak();
    }
}

class Frog {
    private String word;

    public void listen(String word) {
        this.word = word;
    }

    public String speak() {
        return change_word();
    }

    private String change_word() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(change_character(word.charAt(i)));
        }
        return sb.toString();
    }

    private char change_character(char c) {
        if (is_uppercase(c)) {
            return (char) (155 - c);
        }
        if (is_lowercase(c)) {
            return (char) (219 - c);
        }
        return c;
    }

    private boolean is_uppercase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private boolean is_lowercase(char c) {
        return 'a' <= c && c <= 'z';
    }
}