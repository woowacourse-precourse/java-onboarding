package onboarding;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * > 요구사항
 * 1. word를 2개씩 끊어서 연속되게 hash에 저장, 이 때 hash에는 word의 소속을 알기 위해 email을 같이 매핑해준다.
 * 2. 순회하면서 hash key에 word가 있느지 여부에 따라 중복여부를 결정한다.
 * 3. 중복이면 해당 word에 저장된 value인 email과 현재 email을 결과 set에 넣어준다.
 * 4. 정렬해서 출력한다.
 */
public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> wordMap = new HashMap<>();
        Set<String> answer = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int j = 0; j < nickname.length() - 1; ++j) {
                String word = nickname.substring(j, j + 2);
                if (!wordMap.containsKey(word)) {
                    wordMap.put(word, email);
                } else {
                    answer.add(email);
                    answer.add(wordMap.get(word));
                    wordMap.put(word, email);
                }
            }
        }
        return answer.stream()
            .sorted()
            .collect(Collectors.toList());
    }

}

