package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    static int ERROR_NUM = -1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        try {
            for (List<String> form : forms) {
                String email = form.get(0);
                String nickname = form.get(1);

                checkEmail(email);
                checkNickname(nickname);

                for (int i = 0; i < nickname.length() - 1; i++) {
                    String check = nickname.substring(i, i + 2);
                    if (!users.containsKey(check)) {
                        users.put(check, email);
                        continue;
                    }
                    emails.add(users.get(check));
                    emails.add(email);
                }
            }
            answer = emails.stream()
                    .sorted()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            //System.out.print(e.getMessage());
            answer.add(String.valueOf(ERROR_NUM));
        }
        return answer;
    }

    public static void checkNickname(String nickname) throws Exception {
        if (nickname.length() < 1 || nickname.length() >= 20) {
            throw new Exception("닉네임의 전체 길이는 1자 이상 20자 미만이어야 합니다.");
        }
        if (!Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$", nickname)) {
            throw new Exception("닉네임은 한글로만 만들 수 있습니다.");
        }
    }

    public static void checkEmail(String email) throws Exception {
        if (email.length() < 11 || email.length() >= 20) {
            throw new Exception("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
        }
        if (!"@email.com".equals(email.substring(email.length() - 10))) {
            throw new Exception("이메일은 '@email.com' 도메인만 가능합니다.");
        }
        String emailId = email.substring(1, email.length() - 10);
        if (!emailId.matches("^[a-z0-9A-Z]*$")) {
            throw new Exception("이메일은 알파벳과 숫자로만 만들 수 있습니다.");
        }
    }
}
