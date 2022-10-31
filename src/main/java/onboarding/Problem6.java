package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        if(!err_check(forms)) return answer;
        Map<String, String> check_dup = new HashMap<>();
        answer = Dup_Str(check_dup, forms);
        Collections.sort(answer);
        return answer;
    }

    private static boolean err_check(List<List<String>> list){
        //crew is better than 0 and less than 10001
        if(list.size() < 1 || list.size() > 10000) return false;
        String regExp = "^[가-힣]*$";
        for(int i=0;i<list.size();i++){
            //if not only hangeul(Korean), return false
            if(!Pattern.matches(regExp,list.get(i).get(1))) return false;
            //restricted domain <email.com>
            if(!list.get(i).get(0).contains("@email.com")) return false;
            //nickname's length range -> 1 < size < 20
            if(list.get(i).get(1).length() < 1 || list.get(i).get(1).length() >= 20) return false;
            //email length restrict
            if(list.get(i).get(0).length() < 11 || list.get(i).get(0).length() >= 20) return false;
        }
        return true;
    }

    private static List<String> Dup_Str(Map<String, String> s, List<List<String>> f){
        List<String> ans = new ArrayList<>();
        String email, name;
        for(List<String> list:f){
            email = list.get(0);
            name = list.get(1);
            for(int i=0;i<name.length() - 1;i++){
                String if_dup_name = name.substring(i, i + 2);
                if(s.containsKey(if_dup_name)){
                    ans.add(email);
                    if(!ans.contains(s.get(if_dup_name)))
                        ans.add(s.get(if_dup_name));
                    break;
                }
                s.put(if_dup_name, email);
            }
        }
        return ans;
    }
}