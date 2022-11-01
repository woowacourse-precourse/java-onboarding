package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static HashMap<String, List<Integer>> wordDict = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();

        makeDict(forms);

        return answer;
    }

    /**
     * 로직 함수
     */
    private static void makeDict(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; j++) {
                String word = nickname.substring(j, j + 2);
                List<Integer> idxList = wordDict.get(word);

                if (idxList == null) {
                    idxList = new ArrayList<>();
                    idxList.add(i);
                    wordDict.put(word, idxList);
                } else {
                    idxList.add(i);
                }
            }
        }
    }

}
