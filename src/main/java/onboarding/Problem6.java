package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
1. 닉네임 두 글자 이상 연속하여 중복하는 경우 걸러내기

2. 이메일에 대해서는 딱히 걸러야 한다거나 하는 조건은 없다.

3. 단, result는 이메일에해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer", "Hello");

        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );

        System.out.println(Problem6.solution(forms));
    }
}