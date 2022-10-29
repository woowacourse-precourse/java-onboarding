package onboarding;

import java.util.List;

/** 구현해야할 기능
 *  객체 사용 Crew(부모 키, 이메일, 이름)
 *  부모 키의 경우 중복된 이름을 찾는데 도움을 줄 수 있음
 *  ex) 제이슨, 제이엠의 경우 동일한 부모키를 갖는다.
 *  이름을 두글자씩 자른 후 이것을 해시셋으로 저장
 *  ㄴ 객체로 저장 TwoLetters(2글자 이름, 부모 키)
 *  해시셋에 존재한다면 Crew의 부모키를 TwoLetters 부모키로 변경
 *  이메일을 오름차순으로 정렬하는 기능
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
