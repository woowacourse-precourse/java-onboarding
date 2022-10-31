package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();;
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hashmap = new HashMap<>();

        for(int i=0;i<forms.size();i++){
            String name = forms.get(i).get(1);
            for(int j=0;j<name.length()-1;i++){
                String key = name.substring(j,j+1);
                if(hashmap.containsKey(key)){
                    String email = hashmap.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashmap.put(key,forms.get(i).get(0));
            }
        }
        answer = (List<String>) emails.stream();
        Collections.sort(answer);

        return answer;
    }
}
