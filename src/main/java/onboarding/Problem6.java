package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        /*
        * 1. 닉네임을 한글자씩 비교하며 연속으로 같은 문자가 도출될경우 result에 값을 추가하는 기능
        * 2. 그 중 중복되는 값들을 걸러내는 기능
        * */
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

        System.out.println(solution(forms));
    }
}
