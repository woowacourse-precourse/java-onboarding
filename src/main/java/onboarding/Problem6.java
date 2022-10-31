package onboarding;

import java.util.*;

/**\
 * @Problem: 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
 */
public class Problem6 {
    /**
     * @Method: checkNickName
     * 1. 이름을 각각 2글자씩 겹치게 쪼개서 해당 값을 key, 이메일을 value로 HashMap에 저장한다.
     * 2. HashMap에서 Key가 겹치는 경우, 겹치는 닉네임이 존재하는 것이므로 판단한다.
     * 2 - 1. 이때, 한명의 닉네임에 겹치는 단어 (ex: 제이제이)가 존재할 수 있기 때문에, value의 이메일과 현재 이메이을 비교하여 예외처리를 한다.
     * 3. Set을 사용하여 중복되는 이메일을 제거한다.
     * 4. 결과를 정렬한다.
     * 5. 결과를 반환한다.
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}