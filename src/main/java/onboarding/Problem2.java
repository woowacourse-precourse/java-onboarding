package onboarding;

import java.util.Stack;

/**
 *
 * Password_solver
 * 1. save_char(char c) = 문자를 저장
 * 2. saved_char_exist() = 이전에 저장된 문자가 없는지 반환
 * 3. show_recent() = 최근에 저장된 문자를 조회하여 반환
 * 4. recent_has_same_char(char c) = 최근에 저장된 문자와 c가 같은 문자인지 비교하여 반환
 * 5. remove_recent() = 최근에 저장된 문자를 삭제
 * 6. get_recent() = 최근에 저장된 문자를 stack 에서 빼서 반환
 * 7. prepend_recent(StringBuilder sb) = sb의 제일 앞에 최근 저장된 문자를 넣는다.
 * 8. progress(char c) = 문자를 c를 받아서 암호해독과정 진행
 * 9. make_solved_to_string() = 해독이 끝난 암호를 문자열로 생성
 * 10. solve(String cryptogram) = 해독을 진행하고 해독이 끝난 암호를 문자열로 반환
 *
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        Password_solver ps = new Password_solver();
        return ps.solve(cryptogram);
    }
}

class Password_solver {
    Stack<Character> stack;

    Password_solver() {
        stack = new Stack<>();
    }

    private void save_char(char c) {
        stack.push(c);
    }

    private boolean saved_char_exist() {
        return !stack.isEmpty();
    }

    private char show_recent() {
        return stack.peek();
    }

    private boolean recent_has_same_char(char c) {
        return show_recent() == c;
    }

    private void remove_recent() {
        stack.pop();
    }

    private char get_recent() {
        return stack.pop();
    }

    private void prepend_recent(StringBuilder sb) {
        sb.insert(0, get_recent());
    }

    private void progress(char c) {
        if (!saved_char_exist()) {
            save_char(c);
            return;
        }
        if (recent_has_same_char(c)) {
            remove_recent();
            return;
        }
        save_char(c);
    }


    public String make_solved_to_string() {
        StringBuilder sb = new StringBuilder();
        while (saved_char_exist()) {
            prepend_recent(sb);
        }
        return sb.toString();
    }

    public String solve(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            progress(cryptogram.charAt(i));
        }
        return make_solved_to_string();
    }
}