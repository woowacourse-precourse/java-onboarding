package onboarding;

import java.util.Arrays;
import java.util.List;

/**
 * Problem 6
 *
 * 기능 요구 사항
 * 1. 크루들의 닉네임 중 같은 굴자가 연속적 포함되면 사용 제한
 * 2. 따라서 같은 글자가 연속이면 신청한 크루들에게 알려준다.
 * 3. 위 같은 글자를 연속적으로 포함한 크루들의 이메일 목록 return
 *
 * 제한 사항
 * 1. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되면 중복
 * 2. 크루는 1~ 10,000명 이하
 * 3. 이메일은 이메일 형식에 부합, 길이는 11~19
 * 4. 신청 가능한 이메일은 오직 email.com
 * 5. 한글만 가능, 전체 길이 1~19
 * 6. 문자열을 오름차순, 중복은 제거
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
