package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        /* 
        1. 중복되는 닉네님을 체크할 Map 자료구조 사용
        2. forms를 순회하며 2글자씩 끊어 Map key로 사용
        3. Map 카운트가 모두 끝나면 value가 2이상인 key만 추출
        4. forms에서 해당 key를 포함하는 닉네임이면, answer에 없다면 추가
        5. 닉네임 오름차순 정렬
        */

        return answer;
    }
}
