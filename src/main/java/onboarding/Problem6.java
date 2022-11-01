package onboarding;

import java.util.*;

public class Problem6 {

    private static HashMap<String, Set<Integer>> hashMap = new HashMap<>();

    // 같은 글자 포함 닉네임을 담을 Set
    private static Set<Integer> duplicateIdx = new HashSet<>();

    private static void addDuplicateCrews(){
        for (String s : hashMap.keySet()) {
            // Set이 2개 이상이라면, 같은 글자 포함.
            if (hashMap.get(s).size() >= 2){
                for (Integer crewIdx : hashMap.get(s)) {
                    duplicateIdx.add(crewIdx);
                }
            }
        }
    }

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

        // 같은 글자 연속 포함 크루들의 Index를 add.
        addDuplicateCrews();

        // 이메일을 담은 후 정렬
        for (Integer idx : duplicateIdx) {
            answer.add(forms.get(idx).get(0));
        }
        Collections.sort(answer);

        return answer;
    }
}
