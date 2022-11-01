package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> registeredName = new HashMap<>();
        HashSet<String> emailSet = new HashSet<>();

        for(List<String> user : forms){
            for(int i=0; i<user.get(1).length()-1; i++){
                if(registeredName.containsKey(user.get(1).substring(i, i+2))){
                    emailSet.add(registeredName.get(user.get(1).substring(i, i+2)));    //기존에 저장된 이메일 넣기
                    emailSet.add(user.get(0));
                }
                registeredName.put(user.get(1).substring(i, i+2), user.get(0));
            }
        }

        return emailSet.stream().sorted().collect(Collectors.toList());
    }
}
