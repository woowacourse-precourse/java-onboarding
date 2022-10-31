package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();
        Map<String, String> hashMap = new HashMap<>();

        for(List<String> temp : forms){
            String nickname = temp.get(1);
            String email = temp.get(0);

            if(email.length() < 11 || email.length() > 20)  continue;
            if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) continue;
            if(!nickname.matches("^[가-힣]*$")) continue;

            for(int i=0;i<nickname.length()-1;i++){
                String key = nickname.substring(i,i+1);
                if(hashMap.containsKey(key) && !hashMap.get(key).equals(nickname)){
                    emails.add(hashMap.get(key));
                }
                hashMap.put(key, email);
            }
        }

        return emails.stream().sorted().collect(Collectors.toList());
    }
}
