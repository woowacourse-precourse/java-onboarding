package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new java.util.ArrayList<>();
        HashMap<String, Boolean> nicknameMap = new HashMap<>();

        //todo refactor qs

        //중복 문자열들을 저장한다.
        forms.forEach(form -> {
            String nickname = form.get(1);
            for (int i=0; i< nickname.length()-1; i++) {
                String savename = String.valueOf(nickname.charAt(i)) + nickname.charAt(i + 1);
                if (nicknameMap.containsKey(savename)) {
                    nicknameMap.put(savename, true);
                }  else {
                    nicknameMap.put(savename, false);
                }
            }
        });

        //중복값이 있는 이메일을 조회한다.
        forms.forEach(form -> {
            nicknameMap.forEach((k, v) -> {
                if (form.get(1).contains(k) && v) answer.add(form.get(0));
            });
        });

        //중복을 제거하고 정렬한다
        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }
}
