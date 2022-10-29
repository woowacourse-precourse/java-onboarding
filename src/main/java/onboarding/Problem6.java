package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    // HashMap<String, ArrayList<Integer>> charToIndices 생성 : {두 글자 : [닉네임 인덱스]}
    HashMap<String, ArrayList<Integer>> charToIndices = new HashMap<String, ArrayList<Integer>>();
    public static List<String> solution(List<List<String>> forms) {
        // 탐색 Loop forms
        for (int i = 0; i < forms.size(); i++) {
            // updateEvery2SequentialChar : 닉네임에서 2글자씩 분절해  charToIndices에 추가
            updateEvery2SequentialChar(i, forms.get(i).get(1));
        }

        // charToIndices에서 길이가 2이상인 Index 배열 반환
        List<Integer> duplicateIndices = List.of(0);
        // answer 배열 생성
        List<String> answer = List.of("answer");
        // Index 배열을 이용해 aswer에 email add
        return answer;
    }

    static void updateEvery2SequentialChar(int formIdx, String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String key = nickname.substring(i, i + 2);
            ArrayList<Integer> formIndices = this.charToIndices.get(key);
            formIndices.add(formIdx);
            this.charToIndices.put(key, formIndices);
        }
    }
}
