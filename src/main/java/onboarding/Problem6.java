package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> answer;
        String name;
        String email;
        String tmp;

        for(List<String> list : forms){
            email = list.get(0);
            name = list.get(1);
            for(int i=0; i<name.length()-1; i++){
                tmp = name.substring(i, i+2);
                if(map.containsKey(tmp)){
                    set.add(email);
                    set.add(map.get(tmp));
                }else
                    map.put(tmp, email);
            }
        }

        answer = new ArrayList(set);
        Collections.sort(answer);

        return answer;
    }
}
