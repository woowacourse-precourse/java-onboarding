package onboarding;

import java.util.*;

/**
 * @작성자 rjsah09
 * @작성일 2022.10.31
 *
 * @수정내역
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getAnswer(forms);
        return answer;
    }

    private static List<String> getAnswer(List<List<String>> list) {
        Set<String> totalSet = new HashSet<>();

        for(int i = 0 ; i < list.size(); i++) {
            List<String> inf = list.get(i);
            String nickname = inf.get(1);

            Set<String> set = findWithNickname(nickname, i, list);
            totalSet.addAll(set);
        }

        return convertSetToList(totalSet);
    }

    private static Set<String> findWithNickname(String str, int idx, List<List<String>> list) {
        Set<String> totalSet = new HashSet<>();

        for(int j = 0; j < str.length() - 2; j++) {
            for(int k = j + 2; k < str.length(); k++) {
                String keyword = str.substring(j, k);
                Set<String> set = findDuplicated(keyword, idx, list);
                totalSet.addAll(set);
            }
        }

        return totalSet;
    }

    private static Set<String> findDuplicated(String str, int idx, List<List<String>> list) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < list.size(); i++) {
            List<String> inf = list.get(i);
            String email = inf.get(0);
            String nickname = inf.get(1);

            if(i != idx && nickname.contains(str)) {
                set.add(email);
            }
        }

        return set;
    }

    private static List convertSetToList(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

}
