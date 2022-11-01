package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem6 {
    // 문자를 2개 단위로 쪼개서 hashmap을 만든 후 문자를 돌면서 비교
    static List<String> makeHash(List<List<String>> forms){
        Set<String> result = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < forms.size(); i++){
            List<String> target = forms.get(i);
            for(int j = 0; j < target.get(1).length() - 1; j++){
                String piece = target.get(1).substring(j,j+2);
                if (map.containsKey(piece)){// 부분집합이 존재하다면
                    if (i != map.get(piece)) {// 현재 비교하는 닉네임의 부분집합이 아닌 경우
                        result.add(target.get(0)); // 연속적으로 포함되는 글자가 있으므로 result에 이메일 추가
                        result.add(forms.get(map.get(piece)).get(0)); // map에 저장되어 있던 form의 이메일 또한 저장
                    }
                }else{// 부분집합이 존재하지 않는다면
                    map.put(piece,i);// 닉네임의 부분집합과 인덱스를 저장
                }
            }
        }
        List<String> result2 = new ArrayList<>(result);
        return result2;
    }
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        answer = makeHash(forms);
        return answer;
    }
}
