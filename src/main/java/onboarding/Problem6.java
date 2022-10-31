package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        /*
        1. 크루들 닉네임을 2글자씩 분리
        - 크루 각각 분리된 글자가 담긴 set을 갖음
         */

        /*
        2. 연속된 같은 글자가 있는 크루들을 찾아 이메일을 answerSet에 넣음
        - 두 사람씩 비교하여 연속되는 닉네임인지 확인
        - 두 사람 모두 이미 answerSet에 있다면 재비교 하지 않음
        - 두 크루의 닉네임에 연속된 같은 글자가 있는지 확인
         */

        /*
        3. answer에 담아 오름차순 정렬
         */

        return answer;
    }
}
