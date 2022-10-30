package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        TreeSet<String> email_set = new TreeSet<>();

        for(List<String> form : forms){
            String email = form.get(0);
            String nick = form.get(1);
            for(int i = 0 ; i < nick.length() - 1; i++){
                String sub_string = nick.substring(i, i+2);
                if(map.containsKey(sub_string)){
                   email_set.add(email);
                   email_set.add(map.get(sub_string));
                }
                map.put(sub_string, email);
            }
        }
        List<String> answer = new ArrayList<String>(email_set);
        return answer;
    }
}
