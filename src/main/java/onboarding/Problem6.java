package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> ch_name = new HashMap<>();
        for(List<String> a : forms){
            String name = a.get(1);
            for(int i=0; i<name.length()-1; i++){
                String sub = name.substring(i,i+2);
                ch_name.merge(sub, 1, Integer::sum);
            }
        }

        for(List<String> a : forms){
            String mail = a.get(0);
            String name = a.get(1);
            if (is_mail(ch_name,name)){
                answer.add(mail);
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static boolean is_mail(HashMap<String,Integer> ch_name,String name) {
        for(int i=0; i<name.length()-1; i++){
            String sub = name.substring(i,i+2);
            if(ch_name.get(sub)==null) continue;
            else if(ch_name.get(sub)>1) return true;
        }
        return false;
    }

}



