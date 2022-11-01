package onboarding;

import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 제한 사항 2 - 크루는 1명 이상 10,000명 이하이다.
        if (forms.size() < 1 || forms.size() > 10000) {
            answer = List.of();
            return answer;
        }
        // 연속된 두 글자, email을 hashmap으로 담는다.
        HashMap<String, String> map = new HashMap<>();
        // 중복을 제거하기 위해 hashset 사용
        HashSet<String> emails = new HashSet<>();
        final int form_size = forms.size();
        for (int i = 0; i < form_size; i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            int name_size = name.length();
            int email_size = email.length();

            // 제한 사항 5 - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
            if (!name.matches(".*[가-힣]*")) {
                break;
            }
            if (name_size < 2 || name_size > 10000) {
                break;
            }
            // 제한 사항 3 - 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
            if (email_size < 11 || email_size >= 20) {
                break;
            }

            // 제한 사항 4 - 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
            if (!email.contains("@email.com")) {
                break;
            }

            // 제한 사항 1 - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
            for (int j = 0; j < name_size - 1; j++) {
                String segment = name.substring(j, j + 2);
                if (map.containsKey(segment)) {
                    String find_email = map.get(segment);
                    if (!find_email.equals(email)) {
                        emails.add(find_email);
                        emails.add(email);
                    }
                }
                map.put(segment, email);
            }
        }
        // 제한 사항 6 - result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
        answer = emails.stream().sorted().collect(Collectors.toList());

        return answer;
    }
}
