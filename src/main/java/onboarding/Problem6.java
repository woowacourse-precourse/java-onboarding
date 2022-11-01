package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    public static final int INDEX_EMAIL = 0;
    public static final int INDEX_NICKNAME = 1;

    public static final int MIN_NUM_OF_CREWS = 1;
    public static final int MAX_NUM_OF_CREWS = 10000;

    public static final String EMAIL_DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {

        if (isNotValidateForms(forms)) {
            throw new IllegalArgumentException();
        }


        Map<String, Integer> nicknameSubstringCount = new HashMap<>();

        for (List<String> crew : forms) {
            String nickname = crew.get(INDEX_NICKNAME);

            // 닉네임을 크기가 2인 부분집합으로 분리
            List<String> subNicknames = extractSubstringOfNickname(nickname);

            for (String subNickname : subNicknames) {
                Integer count = nicknameSubstringCount.get(subNickname);
                nicknameSubstringCount.put(subNickname, count == null ? 1 : count + 1);
            }
        }


        List<String> emails = new ArrayList<>();

        for (List<String> crew : forms) {
            String email = crew.get(INDEX_EMAIL);
            String nickname = crew.get(INDEX_NICKNAME);

            if (isNeedNotify(nickname, nicknameSubstringCount)) {
                emails.add(email);
            }
        }

        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> extractSubstringOfNickname(String nickname) {
        if (nickname.length() == 1) return List.of();

        List<String> result = new ArrayList<>();

        for (int j = 0; j < nickname.length() - 1; j++) {
            String subNickname = nickname.substring(j, j + 2);
            result.add(subNickname);
        }

        return result;
    }

    private static boolean isNeedNotify(String nickname, Map<String, Integer> nicknameSubstringCount) {
        for (Map.Entry<String, Integer> entry : nicknameSubstringCount.entrySet()) {
            String subNickname = entry.getKey();
            Integer value = entry.getValue();

            if (value > 1 && nickname.matches("[가-힣]*" + subNickname + "[가-힣]*")) {
                return true;
            }
        }

        return false;
    }

    private static boolean isNotValidateForms(List<List<String>> forms) {

        // 크루는 1명 이상 10,000명 이하이다.
        if (!(MIN_NUM_OF_CREWS <= forms.size() && forms.size() <= MAX_NUM_OF_CREWS)) {
            return true;
        }

        for (List<String> crew : forms) {
            String email = crew.get(INDEX_EMAIL);
            String nickname = crew.get(INDEX_NICKNAME);

            // 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다. ('@도메인' 을 제외하고 아이디는 1자 이상 10자 미만)
            // 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
            String emailRegex = "^[\\w.\\-]{1,9}(@" + EMAIL_DOMAIN + ")$";
            if (!email.matches(emailRegex)) {
                return true;
            }

            // 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
            if (!nickname.matches("^[가-힣]{1,19}$")) {
                return true;
            }
        }

        return false;
    }
}

