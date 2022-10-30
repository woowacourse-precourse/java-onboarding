package onboarding;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

class Input6 {
    static Scanner scanner = new Scanner(System.in);
    static String inputEmail() {
        return scanner.next();
    }

    static String inputNickName() {
        return scanner.next();
    }

}

class Crew {

    private final String email;
    private final String nickName;

    Crew(String email, String nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    static void validateEmailLength(String email) {
        if (email.length() < 11 || 20 <= email.length()) {
            throw new IllegalStateException("11자 이상 20자 미만의 이메일을 입력해주세요");
        }
    }

}