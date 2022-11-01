package onboarding;

import java.util.*;

public class Problem6 {
    public HashMap<String,Integer> makeCheckMap(List<List<String>> forms){
        HashMap<String,Integer> map = new HashMap<>();
        for(List<String> form : forms){
            String nickname = form.get(1);
            for(int i=0; i<nickname.length()-1; i++){
                String subNickname = nickname.substring(i,i+2);
                map.put(subNickname, map.getOrDefault(subNickname,0)+1);
            }
        }
        String[] keyArr = map.keySet().toArray(new String[map.size()]);
        for(String key : keyArr){
            if(map.get(key)==1) map.remove(key);
        }
        return map;
    }

    public ArrayList<String> duplicatedEmails(HashMap<String,Integer> map, List<List<String>> forms){
        ArrayList<String> emails = new ArrayList<>();
        for(List<String> form : forms){
            String email = form.get(0);
            String nickname = form.get(1);
            for(String key : map.keySet()){
                if(nickname.contains(key)){
                    emails.add(email);
                    break;
                }
            }
        }
        emails.sort(Comparator.naturalOrder());
        return emails;
    }

    public static List<String> solution(List<List<String>> forms) {
        Problem6 T = new Problem6();

        HashMap<String,Integer> map = T.makeCheckMap(forms);
        List<String> answer = T.duplicatedEmails(map, forms);

        return answer;
    }
}
