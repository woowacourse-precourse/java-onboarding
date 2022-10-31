package onboarding;

import java.util.*;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> gramSet;
        List<Set<String>> gramSetList = new ArrayList<>();
        Map<String, Integer> gramCntMap = new HashMap<>();

        for (List<String> form : forms) {
            gramSet = gramSet(form.get(NICKNAME));
            gramSetList.add(gramSet);
            gramCnt(gramCntMap, gramSet);
        }
        for (int i = 0; i < gramSetList.size(); i++) {
            gramSet = gramSetList.get(i);
            for (String gram : gramSet) {
                if (gramCntMap.get(gram) > 1) {
                    answer.add(forms.get(i).get(EMAIL));
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    private static Set<String> gramSet(String nickname) {
       Set<String> gramSet = new HashSet<>();
       for (int i = 0; i < nickname.length() - 1; i++) {
           gramSet.add(nickname.substring(i, i + 2));
       }
       return gramSet;
    }
    private static void gramCnt(Map<String, Integer> gramCntMap, Set<String> gramSet) {
        for (String gram : gramSet) {
            gramCntMap.put(gram, gramCntMap.getOrDefault(gram, 0) + 1);
        }
    }
}
