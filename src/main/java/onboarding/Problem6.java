package onboarding;

import java.util.*;

public class Problem6 {

    public static void checkAllCombination(StringBuilder name, HashMap<String, List<Integer>> word, int wordIdx) {
        String tmp;

        for (int i = 0; i < name.length()-1; i++) {
            tmp = name.substring(i, i+2);
            if (word.containsKey(tmp)) {
                word.get(tmp).add(wordIdx);
            }
            else {
                word.put(tmp, new ArrayList<Integer>());
                word.get(tmp).add(wordIdx);
            }
        }
    }

    public static void addEmail(Set<Integer> set, List<Integer> wordIdx, Set<String> emailSet, List<List<String>> forms) {
        String emailTmp;
        for (int idx : wordIdx) {
            emailTmp = forms.get(idx).get(0);
            if (!set.contains(idx) && emailTmp.contains("email.com")) {
                set.add(idx);
                emailSet.add(forms.get(idx).get(0));
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        // 1 <= forms.size() <= 10,000
        // 0 <= 닉네임에서 도출될 수 있는 단어 조합 <= 19
        List<String> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<String> emailSet = new HashSet<>();
        HashMap<String, List<Integer>> word = new HashMap<>();
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < forms.size(); i++) {
            name.append(forms.get(i).get(1));

            // 닉네임이 1글자인 경우는 중복이 일어날 수 없음
            if (name.length() == 1) {
                continue;
            }
            else {
                // 닉네임에서 일어날 수 있는 모든 경우의 수를 확인 최대 19개
                checkAllCombination(name, word, i);
            }
            //StringBuilder 초기화
            name.setLength(0);
        }

        // 중복되는 2자리 단어가 존재하는 forms의 index를 확인하고 해당 index의 email을 answer에 추가
        for (String key : word.keySet()) {
            if (word.get(key).size() == 1) {
                continue;
            }
            addEmail(set, word.get(key), emailSet, forms);
        }

        // answer 정렬
        answer = new ArrayList<>(emailSet);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
