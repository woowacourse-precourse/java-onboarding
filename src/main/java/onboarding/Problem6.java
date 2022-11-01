package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;

    private static Map<String, String> emailToNameMap; // 이메일을 KEY, 닉네임을 VALUE로 갖는 해시맵
    private static Set<String> emailSet; // 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록

    public static List<String> solution(List<List<String>> forms) {
        emailToNameMap = new HashMap<>();
        makeEmailToNameMap(forms);

        emailSet = new HashSet<>();
        makeEmailSetByDuplicatedName();

        return sortListByAsc(emailSet);
    }

    // emailToNameMap을 초기화하는 메서드
    public static void makeEmailToNameMap(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(EMAIL);
            String nickName = form.get(NICK_NAME);
            emailToNameMap.put(email, nickName);
        }
    }

    // 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록 리턴하는 메서드
    public static void makeEmailSetByDuplicatedName() {
        emailToNameMap.forEach(
                (email, name) -> {
                    for (int i = 0; i <= name.length() - 2; i++) {
                        String word = name.substring(i, i + 2);
                        emailSet.addAll(emailToNameMap.entrySet().stream()
                                .filter(e -> !Objects.equals(e.getKey(), email))
                                .filter(e -> e.getValue().contains(word))
                                .map(Map.Entry::getKey).collect(Collectors.toSet()));
                    }
                });
    }

    // 리스트를 오름차순 정렬하는 메서드
    public static List<String> sortListByAsc(Set<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }
}
