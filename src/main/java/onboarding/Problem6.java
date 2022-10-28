package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem6 {
    /**
     * 이름을 2글자씩 분해해 wordMap을 업데이트하는 함수 (3글자 이상 중복 되는 경우 2글자도 중복되기 때문에 2글자로만 중복 판단을 한다.)
     * 이때 분해된 단어를 Key로 가지는 List에 email을 추가
     * <pre>
     * 이름 분해 예시 : "제이엠" -> "제이", "이엠"
     * </pre>
     */
    private static void updateWordMap(List<String> userInfo, Map<String, List<String>> wordMap) {
        String email = userInfo.get(0);
        String nickname = userInfo.get(1);

        for (int i = 0; i < nickname.length() - 1; i++) {
            String word = nickname.substring(i, i + 2);

            List<String> emailList = wordMap.getOrDefault(word, new ArrayList<>());

            emailList.add(email);

            wordMap.put(word, emailList);
        }
    }

    /**
     * wordEmailList에 있는 email을 duplicateEmailList에 추가하는 함수
     * 이때 email이 이미 있으면 추가하지 않는다.
     */
    private static void updateDuplicateEmailList(List<String> duplicateEmailList, List<String> wordEmailList) {
        if (wordEmailList.size() <= 1) return;

        for (String email : wordEmailList) {
            if (duplicateEmailList.contains(email)) continue;

            duplicateEmailList.add(email);
        }
    }

    /**
     * WordMap에서 중복된 단어를 가진 유저가 있는 경우 emailList에 추가해 반환하는 함수
     */
    private static List<String> checkDuplicateUser(Map<String, List<String>> wordMap) {
        return Collections.emptyList();
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
