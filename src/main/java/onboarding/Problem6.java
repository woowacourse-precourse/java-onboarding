package onboarding;

import java.util.*;
/*
두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
크루는 1명 이상 10,000명 이하이다.
이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
* */

/*
* 1. forms 내의 모든 닉네임에 대해서 반복
* 2. 닉네임 내부의 모든 길이가 2인 연속된 문자열에 대해서 반복
* 3. map <문자열, 문자열 발생 개수> 저장
* 4.
* 
* */



public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        TreeSet<String> answerSet = new TreeSet<>();
        Map<String, Integer> numberOfDuplication = new HashMap<>();

        for (List<String> form : forms) {
            String tmpName = form.get(1);
            for (int i = 0; i < tmpName.length()-1; i++) {
                numberOfDuplication.put(tmpName.substring(i, i + 2), numberOfDuplication.getOrDefault(tmpName.substring(i, i + 2), 0) + 1);
            }
        }

        for (List<String> form : forms) {
            String tmpName = form.get(1);
            for (int i = 0; i < tmpName.length()-1; i++) {
                if (numberOfDuplication.get(tmpName.substring(i, i+2)) > 1) {
                    answerSet.add(form.get(0));
                    break;
                }
            }
        }
        return new ArrayList<>(answerSet);
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
    }
}
