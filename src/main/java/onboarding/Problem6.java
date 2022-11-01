package onboarding;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static HashSet getEmail(List<List<String>> forms){
        Map<String, String> hashMap = new HashMap<>();
        HashSet<String> emails = new HashSet<>();
        String key ="";
        String nickName;
        String source;

        for(int i =0; i < forms.size();i++) {
            nickName = forms.get(i).get(1);
            source = forms.get(i).get(0);

            for (int j = 0; j < nickName.length() - 1; j++) {
                key = nickName.substring(j, j + 2);
                    if(hashMap.containsKey(key)){
                        String name = hashMap.get(key);
                        if(!name.equals(source)){
                            emails.add(name);
                            emails.add(source);
                        }
                    }

                hashMap.put(key, source);
            }
        }return emails;
    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = (List<String>) getEmail(forms).stream().sorted()
                .collect(Collectors.toList());

        return answer;
    }
}
