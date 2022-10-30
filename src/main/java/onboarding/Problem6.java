package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    static Map<String, Integer> nicknameList = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    private static void inputNameToMap(String name, int index) {
        for (int i = 0; i < name.length() - 2; i++) {
            String subString = name.substring(i, i + 2);
            if(nicknameList.containsKey(subString)) {
                //정답 베열에 넣는 함수
            } else {
                nicknameList.put(name, index);
            }
        }
    }
}
