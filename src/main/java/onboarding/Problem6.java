package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    static class MapValue {
        int cnt;
        Set<String> emailSet;

        public MapValue(String email) {
            this.cnt = 1;
            emailSet = new HashSet<>();
            emailSet.add(email);
        }
    }

    private static final int formsMinSize = 1;
    private static final int formsMaxSize = 10000;
    private static final int emailMinLen = 11;
    private static final int emailMaxLen = 19;
    private static final int nickNameMinLen = 1;
    private static final int nickNameMaxLen = 19;
    private static final Map<String, MapValue> nickNameMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        validateForms(forms);

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            validateEmail(email);
            validateNickName(nickName);
            checkNickNameDuplicated(nickName, email);
        }
        return getResult();
    }

    private static List<String> getResult() {
        Set<String> resultSet = new HashSet<>();
        nickNameMap.values().stream()
            .filter(value -> value.cnt > 1)
            .forEach(value -> resultSet.addAll(value.emailSet));
        return resultSet.stream().sorted().collect(Collectors.toList());
    }

    private static void checkNickNameDuplicated(String nickName, String email) {
        int len = nickName.length();
        for (int j = 0; j < len - 1; j++) {
            addToNickNameMap(nickName.substring(j, j + 1 + 1), email);
        }
    }

    private static void addToNickNameMap(String substring, String email) {
        if (nickNameMap.containsKey(substring)) {
            nickNameMap.get(substring).cnt++;
            nickNameMap.get(substring).emailSet.add(email);
            return;
        }
        nickNameMap.put(substring, new MapValue(email));
    }

    private static void validateForms(List<List<String>> forms) {
        if (forms.size() < formsMinSize || forms.size() > formsMaxSize) {
            throw new IllegalArgumentException("크루는 1명 이상 10000명 이하여야합니다.");
        }
    }

    private static void validateEmail(String email) {
        if (email.length() < emailMinLen || email.length() > emailMaxLen) {
            throw new IllegalArgumentException("이메일은 11자이상 20자 미만이어야합니다.");
        }

        if (!email.matches("^\\w+@email.com$")) {
            throw new IllegalArgumentException("이메일 형식에 부합해야하며, email.com 도메인이어야합니다.");
        }
    }

    private static void validateNickName(String nickName) {
        if (!nickName.matches("^[ㄱ-ㅎ|가-힣]+$")) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
        if (nickName.length() < nickNameMinLen || nickName.length() > nickNameMaxLen) {
            throw new IllegalArgumentException("닉네임은 1자 이상 20자 미만이어야합니다.");
        }
    }
}
