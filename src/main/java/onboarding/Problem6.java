package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>> formsMap = new HashMap<String, ArrayList<Integer>>();
        HashSet<Integer> answerSet = new HashSet<>();

        // FormsMap 만들기
        for(int i = 0; i < forms.size(); i++) {
            List<String> tmp = forms.get(i);
            // tmp.get(1)은 Nickname
            makeFormsMap(tmp.get(1), i, formsMap);
        }

        // AnswerSet 만들기 (중복 제거)
        for(String key : formsMap.keySet()) {
            makeAnswerSet(key, formsMap, answerSet);
        }

        // Answer에 이메일 보낼 사람 추가하기
        for(Integer idx : answerSet) {
            answer.add(forms.get(idx).get(0));
        }

        // Answer 오름차순 정렬하기
        Collections.sort(answer);
        return answer;
    }

    public static void makeFormsMap(String nickName, int idx, HashMap<String, ArrayList<Integer>> formsMap) {
        if(nickName.length() <= 1) {
            return;
        }

        for(int i = 0; i < nickName.length() - 1; i++) {
            String tmp = nickName.substring(i, i + 2);

            if(formsMap.containsKey(tmp)) {
                formsMap.get(tmp).add(idx);
            } else {
                formsMap.put(tmp, new ArrayList<Integer>(Arrays.asList(idx)));
            }
        }
    }

    public static void makeAnswerSet(String key, HashMap<String, ArrayList<Integer>> formsMap, HashSet<Integer> answerSet) {
        if(formsMap.get(key).size() >= 2) {
            for(int i = 0; i < formsMap.get(key).size(); i++) {
                answerSet.addAll(formsMap.get(key));
            }
        }
    }

}
