package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> answerSet; // 알림이 필요한
        HashMap<String, HashSet<String>> words;

        // 크루들 닉네임을 2글자씩 분리
        words = spliteNamePerCrewLength2(forms);

        // 연속된 같은 글자가 있는 크루들을 찾아 answerSet에 넣음
        answerSet = makeAnswerSet(forms, words);

        // answer에 담아 오름차순 정렬
        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        return answer;
    }

    private static HashMap<String, HashSet<String>> spliteNamePerCrewLength2(List<List<String>> forms) {
        HashMap<String, HashSet<String>> words = new HashMap<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            words.put(email, new HashSet<>());
            for(int i = 0; i < name.length() - 1; i++) {
                words.get(email).add(name.substring(i, i + 2));
            }
        }

        return words;
    }

    private static HashSet<String> makeAnswerSet(List<List<String>> forms,
                                      HashMap<String, HashSet<String>> words) {
        HashSet<String> answerSet = new HashSet<>();

        // 두 사람씩 비교하여 연속되는 닉네임인지 확인
        for(int i = 0; i < forms.size() - 1; i++) {
            for(int j = i + 1; j < forms.size(); j++) {
                String firstEmail = forms.get(i).get(0);
                String secondEmail = forms.get(j).get(0);

                // 두 사람 모두 이미 answerSet에 있다면 재비교 하지 않음
                if(answerSet.contains(firstEmail) && answerSet.contains(secondEmail))
                    continue;

                // 드 크루의 닉네임에 연속된 같은 글자가 있는지 확인
                if(isCommon(words.get(firstEmail), words.get(secondEmail))) {
                    answerSet.add(firstEmail);
                    answerSet.add(secondEmail);
                }
            }
        }

        return answerSet;
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
