package onboarding;

import java.util.*;

/**
 * 🚀 기능 요구 사항
 * 우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다.
 * 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.
 *
 * 혼란을 막기 위해 크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한하려 한다.
 * 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.
 *
 * 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록
 * solution 메서드를 완성하라.
 *
 * 제한사항
 * 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
 * 크루는 1명 이상 10,000명 이하이다.
 * 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
 * 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
 * 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 * result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>();
        Map<String, Set<String>> consecutiveSubStringMap = new HashMap<>();
        findEmailListWithDuplicatedNicknames(forms, consecutiveSubStringMap);
        saveEmailListWithDuplicatedNicknames(answer, consecutiveSubStringMap);
        return new ArrayList<>(answer);
    }

    private static void saveEmailListWithDuplicatedNicknames(Set<String> answer, Map<String, Set<String>> consecutiveSubStringMap) {
        for (String nicknameSubString : consecutiveSubStringMap.keySet()) {
            Set<String> duplicatedUsedEmailSet = consecutiveSubStringMap.get(nicknameSubString);
            boolean isDuplicatedNickname = duplicatedUsedEmailSet.size() > 1;
            if (isDuplicatedNickname) {
                answer.addAll(duplicatedUsedEmailSet);
            }
        }
    }

    private static void findEmailListWithDuplicatedNicknames(List<List<String>> forms, Map<String, Set<String>> consecutiveSubStringMap) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            saveConsecutiveSubString(consecutiveSubStringMap, email, nickname);
        }
    }

    private static void saveConsecutiveSubString(Map<String, Set<String>> consecutiveSubStringMap, String email, String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLettersSubString = nickname.substring(i, i + 2);
            if (consecutiveSubStringMap.containsKey(twoLettersSubString)) {
                consecutiveSubStringMap.get(twoLettersSubString).add(email);
                continue;
            }
            consecutiveSubStringMap.put(twoLettersSubString, new HashSet<String>(Collections.singleton(email)));
        }
    }
}
