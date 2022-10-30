package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 이메일과 닉네임을 저장할 HashMap을 초기화하는 함수
    public static HashMap<String, String> initDatabaseOfNickname() {
        return new HashMap<String, String>();
    }

    // 이메일과 닉네임의 중복 여부를 판단할 HashMap을 초기화하는 함수
    public static HashMap<String, Integer> initDuplicationOfNickname() {
        return new HashMap<String, Integer>();
    }
}
