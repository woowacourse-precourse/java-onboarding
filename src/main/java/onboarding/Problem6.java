package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    /*기능구현
    예외처리
    : 크루 1<=, <= 10000 이다.
    : 이메일은 email.com만 가능
    : 이메일 길이는 11<=, <20이다.
    : 닉네임은 한글만 가능, 길이는 1<=, <20이다.
    : result는 오름차순, 중복은 제거하여 출력

    1. 같은 글자가 연속으로 포함된다 -> 2글자만 공통으로 포함되어도 중복으로 간주
    2. 중복된 단어를 가진 닉네임을 저장 -> 해당 이메일을 정렬 후 반환(set이용)
    * */


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String subname = nickname.substring(i, i + 2);

                /* 중복이 있는 이메일을 중복을 가진 자신의 이메일과, 다른 이메일은 모두 result에 저장  */
                if (map.containsKey(subname)) {
                    answer.add(email);
                    answer.add(map.get(subname));

                    break;
                }
                map.put(subname, email);
            }
        }


        return answer.stream().distinct().collect(Collectors.toList());
    }
}
