package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for(int i = 0 ; i < forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            for(int j = 0 ; j < nickname.length() - 1; j++){
                String check1 = nickname.substring(j,j+2);

                if(!users.containsKey(check1)){
                    users.put(check1,email);
                }else{
                    emails.add(users.get(check1));
                    emails.add(email);
                }
            }
        }

        answer = emails.stream()
                .sorted()
                .collect(Collectors.toList());

        return answer;



    }

    public static boolean emailCheck(String email){
        return email.length() >= 11 && email.length() < 20 && Pattern.matches("^[a-z0-9A-Z._-]*@[email]*.[com]*$",email);
    }

    public static boolean nicknameCheck(String nickname){
        return nickname.length() >= 1 && nickname.length() < 20 && Pattern.matches("[가-힣]*$",nickname);
    }
}
