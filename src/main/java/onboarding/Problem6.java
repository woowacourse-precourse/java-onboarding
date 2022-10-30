package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Integer> nicknameList = new HashMap<>();
    static Set<Integer> indexList = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            inputNameToMap(forms.get(i).get(1), i);
        }
        for(int i : indexList) {
            answer.add(forms.get(i).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
    private static void inputNameToMap(String name, int index) {
        for (int i = 0; i < name.length() - 1; i++) {
            String subString = name.substring(i, i + 2);
            if(nicknameList.containsKey(subString)) {
                //정답 배열에 넣는 함수
                putNameIndex(nicknameList.get(subString));
                putNameIndex(index);
            } else {
                nicknameList.put(subString, index);
            }
        }
    }
    private static void putNameIndex(int index) {
        indexList.add(index);
    }

}
