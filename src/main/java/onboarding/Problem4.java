package onboarding;

/**
 * [ Frog ]
 *  - listen(String word) = 청개구리가 문자열을 듣는다.
 *  - speak_changed_word() = 모두 반대로 바꾼 문자열을 반환한다.
 *  - make_changed_word() = 들은 문자열을 바꿔서 반환한다.
 *  - change_character(char c) = c를 알맞게 바꾸어 반환
 *  - is_uppercase(char c) = 현재 문자가 대문자인지 반환
 *  - is_lowercase(char c) = 현재 문자가 소문자인지 반환
 */

public class Problem4 {
    public static String solution(String word) {
        Frog frog = new Frog();
        frog.listen(word);
        return frog.speak_changed_word();
    }
}

class Frog {
    private String word;

    public void listen(String word) {
        this.word = word;
    }

    public String speak_changed_word() {
        return make_changed_word();
    }

    private String make_changed_word() {
        StringBuilder changed = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            changed.append(change_character(word.charAt(i)));
        }
        return changed.toString();
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