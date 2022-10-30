package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

/* 구현 로직
* 1. 연속된 문자가 저장된 해쉬맵이 있다.
* 2. 각 form에 저장되어 있는 닉네임을 가져온다.
*   3. 각 닉네임의 길이부터 2자리까지 모든 것들을 탐색한다.
*       4. 탐색하면서 해쉬맵에 값이 없다면 연속된 문자열을 추가하고 이메일을 넣어준다.
*       5. 만약 해쉬맵에 값이 있다면 해당 해쉬에 이메일만 추가해준다.
* 6. 모든 탐색이 끝난 후 결과에 해쉬맵을 탐색하면서 email이 2개 이상 담긴 경우를 모두 넣어준다.
* 7. 중복을 제거하고 오름차순으로 정렬한다.
* */

/* 기능 목록
* 1. 각 form에 대한 연산을 하는 메소드
*   2. 닉네임에서 n개의 연속된 문자열들을 탐색하는 메소드
*       3. 찾은 문자열을 해쉬맵에 담는 메소드
* 4. 모든 해쉬맵을 탐색하면서 결과를 반환하는 메소드
* */