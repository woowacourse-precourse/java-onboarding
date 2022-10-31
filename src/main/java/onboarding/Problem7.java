package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Set<String>> friend_list = new HashMap<String, Set<String>> (){
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
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //make friend list
        for(List<String>f : friends) {
            String f1 = f.get(0); String f2 = f.get(1);
            friend_list.get(f1).add(f2);
            friend_list.get(f2).add(f1);
        }

        return answer;
    }
}
