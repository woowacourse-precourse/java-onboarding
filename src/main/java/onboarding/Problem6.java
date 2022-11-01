package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Comparator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> emailset = new HashSet<>();
        
        for(int i=0; i<forms.size(); i++){
            String nick = forms.get(i).get(1);

            for(int j=0; j<nick.length() -1; j++){
                String key = nick.substring(j,j+2);
                if(map.containsKey(key)){
                    String email = map.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        emailset.add(email);
                        emailset.add(forms.get(i).get(0));
                    }
                }
                map.put(key, forms.get(i).get(0));
            }
        }
        
        List<String> answer = List.of("answer");
        return answer;
    }
}
