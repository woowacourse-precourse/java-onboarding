package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        Map<String,String> validMap = new HashMap<>();

        List<String> emailList = new ArrayList<>();

        for (int i = 0; i <forms.size() ; i++) {
            List<String> member = forms.get(i);

            String email = member.get(0);
            String nickName = member.get(1);


            for (int j = 0; j <nickName.length()-1 ; j++) {
                String minDuplicatePart = nickName.charAt(j)+""+nickName.charAt(j+1);

                validMap.put(minDuplicatePart,email);

                if(validMap.containsKey(minDuplicatePart)){
                    emailList.add(validMap.get(minDuplicatePart));
                }

            }

        }

        return answer;
    }
}
