package onboarding;

import java.util.*;
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

    static void validateEmailForm(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(!m.matches()) {
            throw new IllegalStateException("올바를 형식의 이메일을 입력해 주세요");
        }
    }

    static void validateNickNameLength(String nickName) {
        if (nickName.length() < 1 || 20 <= nickName.length()) {
            throw new IllegalStateException("1자 이상 20자 미만의 닉네임을 입력해 주세요");
        }
    }

    static void validateNickNameForm(String nickName) {
        String regex = "^[가-힣]*$;";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nickName);
        if(!m.matches()) {
            throw new IllegalStateException("한글만 입력해주세요");
        }
    }

    public List<String> toList() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(this.email);
        temp.add(this.nickName);
        return temp;
    }

}

class NickNameForm {
    private static final Map<String, String> registrationMap = new HashMap<>();

    static void addCrew(List<String> crew) {
        registrationMap.put(crew.get(0), crew.get(1));
    }

}
