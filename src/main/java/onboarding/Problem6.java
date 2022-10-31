package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hashmap = new HashMap<>();

        for(int i=0;i<forms.size();i++){
            String name = forms.get(i).get(1);
            for(int j=0;j<name.length()-1;i++){
                String checkName = name.substring(j,j+1);
                if(hashmap.containsKey(checkName)){
                    String email = hashmap.get(checkName);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashmap.put(checkName,forms.get(i).get(0));
            }
        }

        return answer;
    }
}
