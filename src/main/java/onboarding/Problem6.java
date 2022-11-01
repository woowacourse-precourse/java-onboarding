package onboarding;

import java.util.*;

public class Problem6 {

    // (각 닉네임의 두 글자, 사용자 인덱스)들을 모두 저장
    private static Map<String, Integer> tokenMap = new HashMap<>();

    // 연속된 두 글자 닉네임이 중복되는 크루원 목록
    private static Set<String> foundMemberSet = new HashSet<>();
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 토큰에 대해 중복 검사 후 결과를 저장하는 메소드
    private static void findDuplication(List<List<String>> forms, String token, int idx) {
        System.out.println(token);
        // 중복되는 토큰 있을 경우 -> foundMembers에 두 멤버 저장
        if (tokenMap.containsKey(token)) {
            int tID = tokenMap.get(token);
            foundMemberSet.add(forms.get(tID).get(0));
            foundMemberSet.add(forms.get(idx).get(0));
        }
        // 중복되는 토큰이 없을 경우 -> tokenMap에 토큰 추가
        else {
            tokenMap.put(token, idx);
        }
    }
}
