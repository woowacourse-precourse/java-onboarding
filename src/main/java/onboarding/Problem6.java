package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Set<String>> dup_list = new HashMap<String, Set<String>> (){
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
    public static void make_duplist(List<List<String>> forms){
        for(List<String> f : forms){
            String nickname = f.get(1);
            for(int i = 0; i<nickname.length()-1; i++){
                String sub_nick = nickname.substring(i,i+2);
                dup_list.get(nickname).add(sub_nick);
            }
        }
    }
    public static boolean exist_duplist(String name){
        for(int i = 0; i<name.length()-1; i++){
            String sub_name = name.substring(i,i+2);
            Iterator iter = dup_list.keySet().iterator();
            while(iter.hasNext()){
                String key = iter.next().toString();
                if(key.equals(name)) continue;
                if(dup_list.get(key).contains(sub_name)) return true;
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        make_duplist(forms);

        for(List<String> f : forms){
            String email = f.get(0); String name = f.get(1);
            if(exist_duplist(name)) answer.add(email);
        }
        Collections.sort(answer);

        return answer;
    }
}
