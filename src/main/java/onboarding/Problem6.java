package onboarding;

import java.util.*;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of();

        answer = find_duplicated_email_addresses(forms);
        Collections.sort(answer);

        return answer;
    }

    // 중복된 닉네임을 가진 유저들의 이메일 주소 모두 찾기
    public static List<String> find_duplicated_email_addresses(List<List<String>> forms) {
        Map<String, HashSet<String>> matched_addresses_hash = new HashMap<>();
        Set<String> duplicated_email_addresses = new HashSet<>();

        // 각자 닉네임에서 나올 수 있는 연속된 두글자 조합을 모두 구해서 각 조합에 해당하는 사람이 몇명인 지 확인하면 된다.
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            // 이 유저의 닉네임에서 나올 수 있는 모든 연속된 두 글자 조합에 대하여
            for (int i = 0; i < nickname.length() - 1; i++) {
                String sub_str = nickname.substring(i, i + 2);

                // 이 두글자 조합이 들어간 닉네임을 가진 사람들의 이메일 주소들 (set으로 구현해서 중복이 제거됨)
                HashSet<String> matched_email_addresses = matched_addresses_hash.getOrDefault(sub_str, new HashSet<>());
                matched_email_addresses.add(email);

                // 이 두글자 조합이 들어간 닉네임을 가진 사람들의 수가 2명 이상일 경우
                if (matched_email_addresses.size() > 1) {
                    // 다른사람들과 중복된 닉네임이므로 추가 (set으로 구현해서 중복이 제거됨)
                    duplicated_email_addresses.addAll(matched_email_addresses);
                }

                // 이 두글자 조합이 들어간 닉네임을 가진 사람들의 이메일 주소들에 현재 유저의 이메일도 추가
                matched_addresses_hash.put(sub_str, matched_email_addresses);
            }
        }

        return new ArrayList<>(duplicated_email_addresses);
    }


}
