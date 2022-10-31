package onboarding;

import java.util.*;

/**
 * 1. map을 생성하고, key에 두 글짜씩 substring한 닉네임, value에 사용된 횟수를 저장한다.
 * 2. 이 때, map에서 key값(두 글짜씩 substring한 닉네임)이 2번 이상 사용되었고, email에 포함되지 않았다면 그 이메일을 추가한다.
 * 3. 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬한다.
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> duplication = new HashMap<>();

        for(List<String> list : forms){
            String nickname = list.get(1);
            for(int i = 0; i < nickname.length()-1; i++){
                String strcase = nickname.substring(i, i+2);
                duplication.put(strcase, duplication.getOrDefault(strcase, 0) +1);
            }
        }

        for(List<String> list: forms) {
            String email = list.get(0);
            String nickname = list.get(1);
            for(int i = 0; i < nickname.length()-1; i++){
                String strcase = nickname.substring(i, i+2);
                if(duplication.get(strcase) >= 2 && !result.contains(email)){
                    result.add(email);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
