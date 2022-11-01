package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> searchDuplicate(List<List<String>> forms) {
        HashMap<String, Integer> allNicknameElements = new HashMap<String, Integer>();
        String nickname;
        HashSet<String> nicknameElements;
        for (int i = 0; i < forms.size(); i++) {
            nicknameElements = new HashSet<>();
            nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                nicknameElements.add(nickname.substring(i, i+2));
            }
            // hashmap에 이미 key값이 있으면 +=1, 없으면 추가하고 value값 1로 지정
            for (String nicknameElement : nicknameElements) {
                if (allNicknameElements.containsKey(nicknameElement)) {
                    allNicknameElements.put(nicknameElement,allNicknameElements.get(nicknameElement) + 1);
                } else {
                    allNicknameElements.put(nicknameElement, 1);
                }
            }



        }
    }
}
