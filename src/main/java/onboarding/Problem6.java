package onboarding;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> hashList = new HashMap<>();
        HashSet<String> emailList = new HashSet<>();
        for(int i=0;i<forms.size();i++){
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);
                if(hashList.containsKey(key)){
                    String email = hashList.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        emailList.add(email);
                        emailList.add(forms.get(i).get(0));
                    }
                }
                hashList.put(key, forms.get(i).get(0));
            }
        }
        List<String> collect = emailList.stream().sorted().collect(Collectors.toList());
        answer = collect;
        for(int k=0;k< collect.size();k++){
            System.out.println(collect.get(k));
        }
        return answer;
    }
}
