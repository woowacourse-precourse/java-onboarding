package onboarding;

import java.util.*;

public class Problem6 {

    public static HashMap<String, Set<Integer>> hashMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // ("자른 문자열", set of idx)로 hashMap에 넣는다.
        for (int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);

            // 닉네임 길이가 1이라면 고려 대상이 아니다.
            if (name.length() == 1) continue;

            // (j, j+1)로 두 글자씩 쪼갠다.
            for (int j = 0; j < name.length() - 1; j++){
                String currPart = name.substring(j, j + 2);

                // 2글자가 Map에 없다면 Initialize
                hashMap.computeIfAbsent(currPart, s -> new HashSet<>());
                hashMap.get(currPart).add(i);
            }
        }

        return answer;
    }
}
