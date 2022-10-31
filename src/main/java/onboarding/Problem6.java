package onboarding;

import java.util.List;

/*

[기능 목록]
1. 입력값 2차원 리스트를 Map 으로 다루기 위한 변환 메서드
2. 닉네임 중복 여부를 담고 있는 Map 생성 메서드 -> {Email : Nickname} 형태로 생성하기
3. 2번 메서드의 Key 값에 대입하기 위하여 모든 닉네임을 추출하는 메서드
4. 2번 메서드의 Key 값으로 반환값인 이메일을 얻기 위하여 1번에서 얻어낸 Map에서 Nickname 으로 Email을 추출하는 메서드
5. 중복 확인을 위한 검사 양식을 만드는 메서드
6. 중복 검사 후 그 결과를 2번 메서드로 부터 얻은 Map 에 반영하는 메서드
7. 중복 검사 메서드를 호출하는 메서드
8. 중복 여부를 담고있는 Map을 결과값에 맞춰 List로 변환하는 메서드

 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
