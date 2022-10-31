package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> answerSet = new HashSet<>();
        HashMap<String, HashSet<String>> words = new HashMap<>();

        // 크루들 닉네임을 2글자씩 분리
        for(List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            words.put(email, new HashSet<>());
            for(int i = 0; i < name.length() - 1; i++) {
                words.get(email).add(name.substring(i, i + 2));
            }
        }

        // 연속되는 글자가 있는지 확인
        for(int i = 0; i < forms.size() - 1; i++) {
            for(int j = i + 1; j < forms.size(); j++) {
                String firstEmail = forms.get(i).get(0);
                String secondEmail = forms.get(j).get(0);
                if(answerSet.contains(firstEmail) && answerSet.contains(secondEmail))
                    continue;
                if(isCommon(words.get(firstEmail), words.get(secondEmail))) {
                    answerSet.add(firstEmail);
                    answerSet.add(secondEmail);
                }
            }
        }

        // answer에 담아 오름차순 정렬
        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        return answer;
    }

    private static boolean isCommon(HashSet<String> set1, HashSet<String> set2) {
        for(String token1 : set1) {
            for(String token2 : set2) {
                if(token1.equals(token2))
                    return true;
            }
        }
        return false;
    }
}
