package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (isError(forms)) {
            return answer = List.of("-1");
        }
        return answer;
    }

    public static boolean isError(List<List<String>> forms) {
        boolean flag = false;
        if (forms.size() < 1 || forms.size() > 10000) { // 크루 수
            flag = true;
        }
        for (List<String> form : forms) {
            if (form.get(0).length() < 11 || form.get(0).length() >= 20) { // 이메일 길이
                flag = true;
            }
            if (!form.get(0).split("@")[1].equals("email.com")) { // 이메일 도메인
                flag = true;
            }
            if (!form.get(1).matches("^[가-힣]")) { // 닉네임 한글
                flag = true;
            }
            if (form.get(1).length() < 1 || form.get(1).length() >= 20) { // 닉네임 길이
                flag = true;
            }
        }
        return flag;
    }
}
