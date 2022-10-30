package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한
 * 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템
 * "같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 리턴"
 *
 * --> 수정 --> 제한사항에서 result 의 이메일 문자열의 중복을 제거한다를 발견 후 코드 수정
 * 1. stream 을 사용하여 result 를 오름차순 정렬 한 후 중복을 제거해줌.
 **/
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[forms.size()];

        for (List<String> formList : forms) {
            String str = formList.get(1);
            Set<String> set = new HashSet<>();
            for (int j = 0; j < str.length() - 1; j++) {
                String sub = str.substring(j, j + 2);
                if (set.contains(sub)) {
                    continue;
                } else {
                    set.add(sub);
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }
            }
        }

        int k = 0;
        for (List<String> formList : forms) {
            String str = formList.get(1);
            for (String key : map.keySet()) {
                if (map.get(key) >= 2 && str.contains(key)) {
                    visited[k] = true;
                    break;
                }
            }
            k++;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                answer.add(forms.get(i).get(0));
            }
        }

        // stream 을 사용하여 result 를 오름차순 정렬 한 후 중복을 제거해줌.
        List<String> collect = answer.stream().sorted().distinct().collect(Collectors.toList());

        return collect;
    }
}
