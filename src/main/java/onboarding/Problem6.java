package onboarding;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 1. 중복되는 닉네님을 체크할 Map 자료구조 사용
        Map<String, Integer> overlapMap = new HashMap<>();
        
        // 2. forms를 순회하며 2글자씩 끊어 Map key로 사용
        for ( int i = 0 ; i < forms.size(); i ++ ){
            String nickname = forms.get(i).get(1);
            for ( int j = 0 ; j < nickname.length() - 1 ; j ++ ){
                String partition = nickname.substring(j, j+2);
                overlapMap.put(partition, overlapMap.getOrDefault(partition, 0) + 1);
            }
        }

        // 3. Map 카운트가 모두 끝나면 value가 2이상인 key만 추출
        for( String key : overlapMap.keySet() ){
            if ( overlapMap.get(key) > 1 ) {
                for ( int i = 0 ; i < forms.size() ; i ++ ){
                    if ( forms.get(i).get(1).contains(key) && ! answer.contains(forms.get(i).get(0)))
                        answer.add(forms.get(i).get(0));
                }
            }
        }
        // 4. forms에서 해당 key를 포함하는 닉네임이면, answer에 없다면 추가
        for ( int i = 0 ; i < answer.size() ; i ++ ) System.out.println(answer.get(i));

        // 5. 닉네임 오름차순 정렬
        Collections.sort(answer);
        
        return answer;
    }
}
