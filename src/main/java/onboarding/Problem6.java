package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    private static void checkNameMap(String nameSlice, String email) {
        if (nameMap.containsKey(nameSlice)) {       // 이름 2글자가 중복된다면,
            emails.add(nameMap.get(nameSlice));         // answer 배열에 중복되는 이름 있는 메일 추가
            emails.add(email);                           // 체크하는 현재 메일도 추가
        }
        if (!nameMap.containsKey(nameSlice)) {      // 중복 이름이 없다면
            nameMap.put(nameSlice, email);              // hashmap에 새로운 key 저장
        }
    }
}
