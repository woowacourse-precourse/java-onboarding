package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        final Map<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            final String name = forms.get(i).get(1);

            if (name.length() < 2) {
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j + 2);
                if (hashMap.containsKey(key)) {
                    final String email = hashMap.get(key);
                    if (!email.equals(forms.get(i).get(0))) {
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(key, forms.get(i).get(0));
            }
        }
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }
    // 중복 글자 찾는 함수

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
}