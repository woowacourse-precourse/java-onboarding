package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Set<String>> dup_list = new HashMap<String, Set<String>>(){
        @Override
        public Set<String> get(Object key){
            Set<String> set = super.get(key);
            if(set == null){
                set = new HashSet<String>();
                put((String) key,set);
            }
            return set;
        }
    };
    static Map<String, String> user_list = new HashMap<String, String>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for(List<String> f : forms){
            String email = f.get(0); String nickname = f.get(1);
            for(int i = 0; i<nickname.length()-1; i++){
                String sub_nick = nickname.substring(i,i+2);
                dup_list.get(nickname).add(sub_nick);
            }
        }
        return answer;
    }
}
