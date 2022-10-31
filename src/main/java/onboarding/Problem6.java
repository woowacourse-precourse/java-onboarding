package onboarding;

import java.util.*;

public class Problem6 {
    static Set<String> dup_list = new HashSet<String>();

    public static void make_duplist(List<List<String>> forms){
        for(List<String> f : forms){
            String nickname = f.get(1);
            for(int i = 0; i<nickname.length()-1; i++){
                String sub_nick = nickname.substring(i,i+2);
                dup_list.add(sub_nick);
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        make_duplist(forms);

        return answer;
    }
}
