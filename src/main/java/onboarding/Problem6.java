package onboarding;


import java.util.*;
import java.util.stream.Collectors;


public class Problem6 {
    private static boolean limitations(List<List<String>> forms) {
        if(!(forms.size()>=1 && forms.size() <= 1000))
            return false;

        for(List<String> string : forms) {
            String email=string.get(0);
            if(!(email.length()>=11 && email.length() <= 20))
                return false;

            int idx = email.indexOf("@");
            String domain = email.substring(idx+1);
            if(!(domain.contains("email.com")))
                return false;

            String nickname = string.get(1);
            if(!(nickname.matches("^[가-힣]*$") && nickname.length() >=20))
                return false;
        }
        return true;
    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> crewMap = new HashMap<>();
        for (List<String> crew : forms) {
            String emailAccount = crew.get(0);
            String nickname = crew.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String key = nickname.substring(i, i + 2);
                if (crewMap.containsKey(key)) {
                    answer.add(emailAccount);
                    if (!answer.contains(crewMap.get(key))) {
                        answer.add(crewMap.get(key));
                    }
                }
                crewMap.put(key, emailAccount);
            }
        }
        return answer.stream().sorted().collect(Collectors.toList());
    }
}

