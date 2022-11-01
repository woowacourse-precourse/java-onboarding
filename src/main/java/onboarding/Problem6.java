package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();

        HashSet<String> emails = new HashSet<>();



        for(int i = 0 ; i<forms.size(); i++){
            String name = forms.get(i).get(1);
            if(name.length() < 2){
                break;
            }

            for(int j = 0 ;  j < name.length()-1; j++){
                String key = name.substring(j,j+2);
                if(map.containsKey(key)){
                    String email = map.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }

                }
                map.put(key,forms.get(i).get(0));

            }
        }
        List<String> answer = emails.stream()
                .sorted().collect(Collectors.toList());

        return answer;
    }


}
