package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    private static final Map<String, String> usingNameMap = new HashMap<>();
    private static final Set<String> renamedListSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        forms.stream()
                .filter(Problem6::isCheckForms)
                .forEach(Problem6::validateSameName);

        List<String> answer = renamedListSet.stream()
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }

    private static void validateSameName(List<String> list) {
        String name = list.get(1);
        for (int i = 0; i < name.length() - 1; i++) {
            String subName = name.substring(i, i + 2);
            if (!usingNameMap.containsKey(subName)) {
                usingNameMap.put(subName, list.get(0));
            } else {
                renamedListSet.add(usingNameMap.get(subName));
                renamedListSet.add(list.get(0));
            }
        }
    }

    private static boolean isCheckForms(List<String> list) {
        return list.size() == 2
                && isCheckEmail(list.get(0))
                && isCheckName(list.get(1));
    }

    private static boolean isCheckEmail(String email) {
        return 11 <= email.length()
                && email.length() < 20
                && email.endsWith("email.com");
    }

    private static boolean isCheckName(String name) {
        return 1 <= name.length()
                && name.length() < 20
                || name.matches("[가-힣]+");
    }
}
/*
문제 설명
  1. 신청받은 닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 리턴한다.

제한사항 및 주의할점
  - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복 간주
  - 크루는 1명 이상 10,000명 이하
  - 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만
  - 신청할 수 있는 이메일은 email.com 도메인으로만 제한
  - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만
  - result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거함
 */