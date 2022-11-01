package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static final String EMAIL_DOMAIN = "email.com";
    public static List<String> solution(List<List<String>> forms) {
        try {
            validateInput(forms);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        HashMap<String, String> nickName = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> overlapCrew = findOverlapCrew(forms.get(i).get(1), forms.subList(i + 1, forms.size()));
            if (overlapCrew.size() > 0) {
                nickName.put(forms.get(i).get(0), "");
            }
            for (String user : overlapCrew) {
                nickName.put(user, "");
            }
        }

        List<String> answer = new ArrayList<>(nickName.keySet());
        Collections.sort(answer);
        return answer;
    }

    private static List<String> findOverlapCrew(String nickName, List<List<String>> forms) {
        List<String> overlappedCrew = new ArrayList<>();

        for (int i = 0; i < nickName.length() - 1; i++) {
            for (int j = 2; i + j <= nickName.length(); j++) {
                String name = nickName.substring(i, i + j);
                for (List<String> form : forms) {
                    if (form.get(1).contains(name)) {
                        overlappedCrew.add(form.get(0));
                    }
                }
            }
        }
        return overlappedCrew;
    }

    private static void validateInput(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하입니다.");
        }

        for (List<String> user : forms) {
            if (user.get(0).length() < 11 || user.get(0).length() > 20) {
                throw new IllegalArgumentException("이메일은 11자 이상 20자 미만입니다.");
            }
            if (!(user.get(0).endsWith(EMAIL_DOMAIN))) {
                throw new IllegalArgumentException("잘못된 이메일 도메인입니다.");
            }
            if (!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", user.get(1))) {
                throw new IllegalArgumentException("닉네임은 한글만 사용할 수 있습니다.");
            }
            if (user.get(1).length() < 1 || user.get(1).length() > 20) {
                throw new IllegalArgumentException("닉네임은 1글자 이상, 20글자 미만이어야 합니다.");
            }
        }
    }
}
