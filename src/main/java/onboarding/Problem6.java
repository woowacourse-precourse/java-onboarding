package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static class User {
        private String email;
        private String nickname;

        public User(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        List<String> emails = new ArrayList<>();
        Map<String, String> subNickNames = new HashMap<>();

        List<User> userList = new ArrayList<>();
        forms.forEach(form -> userList.add(new User(form.get(0), form.get(1))));
        
        for(int i=0; i<userList.size(); i++) {
            User user = userList.get(i);
            String nickname = user.nickname;
            if(nickname.length() < 2)
                continue;
            for(int j=0; j<nickname.length()-1; j++) {
                String subNickname = nickname.substring(j, j+2);
                if(subNickNames.containsKey(subNickname)) { // 닉네임 중복 가능성 O
                    String email = subNickNames.get(subNickname);
                    if(!email.equals(user.email)) {
                        emails.add(email);
                        emails.add(user.email);
                    }
                }
                subNickNames.put(subNickname, user.email);
            }
        }
        answer = emails.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }

}
