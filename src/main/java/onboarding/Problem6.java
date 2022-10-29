package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 1. 길이별 딕셔너리 저장
        HashMap<String, Set<String>> map = new HashMap<>();
        for (List<String> form : forms){
            String email = form.get(0);
            String fullname = form.get(1);

            if (fullname.length() > 1){
                for (int l = 2; l <= fullname.length(); l++){
                    int s = 0;
                    while (s + l <= fullname.length()){
                        String keyToAdd = fullname.substring(s, s + l);
                        if (map.containsKey(keyToAdd))
                            map.get(keyToAdd).add(email);
                        else {
                            Set<String> valueSet = new HashSet<>();
                            valueSet.add(email);
                            map.put(keyToAdd, valueSet);
                        }
                        s++;
                    }
                }
            }
        }

        // 2. value의 길이가 2 이상인 크루의 이메일을 뽑아서 정렬해서 return 하기
        List<String> answer = List.of("answer");
        return answer;
    }
}
