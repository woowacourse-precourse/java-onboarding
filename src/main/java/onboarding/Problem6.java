package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    static class Id {

        private String nickname;
        private String email;

        public String getNickname() {
            return nickname;
        }


        public String getEmail() {
            return email;
        }

        public Id(String nickname, String email) {
            this.nickname = nickname;
            this.email = email;

        }
    }

    static Map<String, Integer> nicknameMap = new HashMap<>();
    static Set<Integer> answerSet = new HashSet<>();

    static void calc(String s, Integer idx) {
        for (int i = 0; i + 1 < s.length(); i++) {
            if (nicknameMap.containsKey(s.substring(i, i + 2))) {
                if (!Objects.equals(nicknameMap.get(s.substring(i, i + 2)), idx)) {
                    answerSet.add(idx);
                    answerSet.add(nicknameMap.get(s.substring(i, i + 2)));
                }
            } else {
                nicknameMap.put(s.substring(i, i + 2), idx);
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        nicknameMap.clear();
        answerSet.clear();

        List<Id> ids = forms.stream().map(s -> new Id(s.get(1), s.get(0))).collect(Collectors.toList());

        for (int i = 0; i < ids.size(); i++) {
            calc(ids.get(i).nickname, i);
        }
        List<Integer> ans = new ArrayList<>(answerSet);
        Set<String> answer = new HashSet<>();
        ans.forEach((i) -> answer.add(ids.get(i).getEmail()));
        List<String> result = new ArrayList<>(answer);
        Collections.sort(result);
        return result;
    }
}
