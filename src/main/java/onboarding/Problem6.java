package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Set<String>> words;
        Set<String> answerSet; // 알림이 필요한 크루들의 이메일을 저장

        /*
        1. 크루들 닉네임을 2글자씩 분리
        - 크루 각각 분리된 글자가 담긴 set을 갖음
         */
        words = spliteNamePerCrewLength2(forms);

        /*
        2. 연속된 같은 글자가 있는 크루들을 찾아 이메일을 answerSet에 넣음
        - 두 사람씩 비교하여 연속되는 닉네임인지 확인
        - 두 사람 모두 이미 answerSet에 있다면 재비교 하지 않음
        - 두 크루의 닉네임에 연속된 같은 글자가 있는지 확인
         */
        answerSet = makeAnswerSet(forms, words);

        /*
        3. answer에 담아 오름차순 정렬
         */

        return answer;
    }

    private static Map<String, Set<String>> spliteNamePerCrewLength2(List<List<String>> forms) {
        Map<String, Set<String>> words = new HashMap<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            words.put(email, new HashSet<>());

            for(int i = 0; i < name.length() - 1; i++)
                words.get(email).add(name.substring(i, i + 2));
        }
        return words;
    }

    private static Set<String> makeAnswerSet(List<List<String>> forms,
                                                 Map<String, Set<String>> words) {
        Set<String> answerSet = new HashSet<>();

        for(int i = 0; i < forms.size() - 1; i++) {
            for(int j = i + 1; j < forms.size(); j++) {
                String firstPersonEmail = forms.get(i).get(0);
                String secondPersonEmail = forms.get(j).get(0);

                if(answerSet.contains(firstPersonEmail) && answerSet.contains(secondPersonEmail))
                    continue;

                if(hasCommonToken(words.get(firstPersonEmail), words.get(secondPersonEmail))) {
                    answerSet.add(firstPersonEmail);
                    answerSet.add(secondPersonEmail);
                }
            }
        }

        return answerSet;
    }

    private static boolean hasCommonToken(Set<String> set1, Set<String> set2) {
        for(String token1 : set1) {
            for(String token2 : set2) {
                if(token1.equals(token2))
                    return true;
            }
        }
        return false;
    }
}
