package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();//중복 제거
        Map<String, String> hm=new HashMap<>();

        for(int i=0;i<forms.size();i++){
            String name=forms.get(i).get(1);

            if(name.length()<2){
                break;
            }

            for(int j=0;j<name.length()-1;j++){
                String k=name.substring(j,j+2);
                if(hm.containsKey(k)){
                    String email=hm.get(k);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hm.put(k,forms.get(i).get(0));
            }
        }

        List<String> answer=emails.stream().sorted().collect(Collectors.toList());

        return answer;
    }
}
