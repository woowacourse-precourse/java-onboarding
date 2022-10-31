package onboarding;

import java.util.*;

/*
* 기능 목록
* 1. 닉네임 중복 여부 확인
* 2. 모든 크루들에 대해 닉네임 중복 검사
* */
public class Problem6 {

    // 닉네임 중복 여부 확인
    public static boolean isDuplicateNickname(String nicknameA, String nicknameB) {
        // 2글자씩만 비교하면 됨
        for (int i = 0; i < nicknameA.length() - 1; i++) {
            if (nicknameB.contains(nicknameA.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }
    // 모든 크루들에 대해 닉네임 중복 검사
    public static List<String> getDuplicateNicknameUserList(List<List<String>> forms) {
        // set을 통해 중복 방지
        Set<String> ans = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = i+1; j < forms.size(); j++) {
                List<String> formA = forms.get(i);
                List<String> formB = forms.get(j);
                if (isDuplicateNickname(formA.get(1), formB.get(1))) {
                    ans.add(formA.get(0));
                    ans.add(formB.get(0));
                }
            }
        }
        List<String> answer = new ArrayList<>(ans);
        // 오름차순 정렬
        Collections.sort(answer);

        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        return getDuplicateNicknameUserList(forms);
    }


}
