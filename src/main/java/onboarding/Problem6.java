package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    /*
        기능 요구 사항 목록
        1. 사용자의 닉네임만 추출하는 함수
        2. 사용자의 이메일만 추출하는 함수
        3. 연속될 수 있는 문자열 추출 함수
        4. 문자열 카운터 해시맵 생성 함수
        5. 해시맵에서 값이 1보다 큰 키만 추출하는 함수
        6. 중복 문자열이 포함된 이메일 추출 함수
        7. solution (함수 순서대로 실행)
    */

    // 사용자의 닉네임만 추출하는 함수
    private static List<String> allNicknames(List<List<String>> forms) {
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            nicknames.add(nickname);
        }
        return nicknames;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
