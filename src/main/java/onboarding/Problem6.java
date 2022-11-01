package onboarding;

import java.util.*;

public class Problem6 {

    // (각 닉네임의 두 글자, 사용자 인덱스)들을 모두 저장
    private static Map<String, Integer> tokenMap = new HashMap<>();

    // 연속된 두 글자 닉네임이 중복되는 크루원 목록
    private static Set<String> foundMemberSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {

        for (int i = 0; i < forms.size(); i++) {
            List<String> member = forms.get(i);
            String nickname = member.get(1);
            List<String> tokens = splitNickname(nickname);

            // 닉네임의 모든 토큰에 대해서 중복 검사
            for (String token : tokens) {
                findDuplication(forms, token, i);
            }
        }

        List<String> foundMembers = new ArrayList<>(foundMemberSet);
        foundMembers.sort((s1, s2) -> s1.compareTo(s2));

        return foundMembers;
    }

    // 닉네임을 두 글자의 토큰들의 리스트로 나누는 메소드
    private static List<String> splitNickname(String nickname) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            ret.add(nickname.substring(i, i + 2));
        }
        return ret;
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
