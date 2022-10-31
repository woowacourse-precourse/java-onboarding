package onboarding;

import java.util.List;

/*
* 기능 목록
* 1. 닉네임 중복 여부 확인
* 2. 모든 크루들에 대해 닉네임 중복 검사
* */
public class Problem6 {

    // 닉네임 중복 여부 확인
    public static boolean compareNickName(String nicknameA, String nicknameB) {
        // 2글자씩만 비교하면 됨
        for (int i = 0; i < nicknameA.length() - 1; i++) {
            if (nicknameB.contains(nicknameA.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
