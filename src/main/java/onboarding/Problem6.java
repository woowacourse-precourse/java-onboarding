package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<String>> combi = new HashMap<>();

        for(List<String> form : forms){
            NickName2Combi(combi, form);
        }
        System.out.println("combi.values() = " + combi.values());
        System.out.println("combi.keySet() = " + combi.keySet());
        return answer;
    }

    public static void NickName2Combi(Map<String, List<String>> combi, List<String> form){
        String nickName = form.get(1);
        String email = form.get(0);

        if (nickName.length() == 1)     return ;

        for(int i=0 ; i<nickName.length()-1; i++){
            String pairs = nickName.substring(i, i+2);
            if(combi.containsKey(pairs))
                combi.get(pairs).add(email);
            else
                combi.put(pairs,new ArrayList<>(List.of(email)));
        }
    }

}
