package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        Map<String,String> validMap = new HashMap<>();

        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i <forms.size() ; i++) {
            List<String> members = forms.get(i);

            String email = members.get(0);
            String nickName = members.get(1);


            for (int j = 0; j <nickName.length()-1 ; j++) {
                String minDuplicatePart = nickName.charAt(j)+""+nickName.charAt(j+1);

                validMap.put(minDuplicatePart,email);

                if(validMap.containsKey(minDuplicatePart)){

                    emailSet.add(email);
                    emailSet.add(validMap.get(minDuplicatePart));

                }else {

                    validMap.put(minDuplicatePart,email);

                }
            }

        }

        return answer;
    }
}
