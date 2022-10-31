package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String,String> m = new HashMap<>();
        Set<String> s = new HashSet<>();
        String nickname;
        String email;
        String twoLetters;
        for(List<String> l: forms) {
            email = l.get(0);
            nickname = l.get(1);
            for(int j = 0;j < nickname.length()-1; j++) {
                twoLetters = nickname.substring(j,j+2);
                if(m.containsKey(twoLetters)) {
                    s.add(m.get(twoLetters));
                    s.add(email);
                } else {
                    m.put(twoLetters, email);
                }
            }
        }

        List<String> emailList = new ArrayList<>();
        emailList.addAll(s);
        String[] emailArray = new String[emailList.size()];
        emailList.toArray(emailArray);
        Arrays.sort(emailArray);
        answer = List.of(emailArray);


        return answer;
    }



}
