package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> crews = new HashMap<>();
        for(List<String> person : forms) {
            String email = person.get(0);
            String nickName = person.get(1);
            if(email.contains("email.com") && (email.length() >= 1 && email.length() <20))
                   crews.put(nickName, email);
        }

        ArrayList<String> nickNames = new ArrayList<>(crews.keySet());
        ArrayList<String> emails = new ArrayList<>();

        for(int i=0; i<nickNames.size(); i++) {
            String item1 = nickNames.get(i);
            for(int j=i+1; j<nickNames.size(); j++) {
                String item2 = nickNames.get(j);
//                for(int k=0; k<item1.length(); k++){
//
//                }
            }
        }

        List<String> answer = new ArrayList<>();
        for(String email : emails) {
            if(!answer.contains(email))
                answer.add(email);
        }

        Collections.sort(answer);
        return answer;
    }
}
