package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> emails = new HashSet<>();
        Map<String, String > hashMap = new HashMap<>();
    
        for (int i = 0; i < forms.size(); i++) {

            final String name = forms.get(i).get(1);

            if(name.length() < 2){
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    final String email = hashMap.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        answer.add(email);
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(key, forms.get(i).get(0));
            }
        }

        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }
   
}
