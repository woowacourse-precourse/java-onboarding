package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import onboarding.exception.CustomException;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;

    public static List<String> solution(List<List<String>> forms) {

        try {
            // 이메일을 KEY, 닉네임을 VALUE로 갖는 해시맵 생성
            Map<String, String> emailToNameMap = makeEmailToNameMap(forms);

            // 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록
            Set<String> emailSet = getEmailSetWithDuplicatedName(emailToNameMap);

            // 오름차순 정렬한 리스트 반환
            List<String> answer = sortListByAsc(emailSet);

            return answer;
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 이메일을 KEY, 닉네임을 VALUE로 갖는 해시맵을 생성하는 메서드
    public static Map<String, String> makeEmailToNameMap(List<List<String>> forms)
            throws CustomException {
        Map<String, String> map = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(EMAIL);
            String nickName = form.get(NICK_NAME);
            map.put(email, nickName);
        }
        return map;
    }

    // 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록 리턴하는 메서드
    public static Set<String> getEmailSetWithDuplicatedName(Map<String, String> emailToNameMap) {
        // Set 자료형: 중복 제거 위함
        Set<String> emailSet = new HashSet<>();
        emailToNameMap.forEach(
                (email, name) -> {
                    for (int i = 0; i <= name.length() - 2; i++) {
                        String word = name.substring(i, i + 2);
                        emailSet.addAll(emailToNameMap.entrySet().stream()
                                .filter(e -> !Objects.equals(e.getKey(), email))
                                .filter(e -> e.getValue().contains(word))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toSet()));
                    }
                });

        return emailSet;
    }

    // 리스트를 오름차순 정렬하는 메서드
    public static List<String> sortListByAsc(Set<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }
}
