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
    private static Map<String, String> subNickNames = new HashMap<>();
    private static List<String> emails = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<User> userList = new ArrayList<>();
        forms.forEach(
                form -> userList.add(new User(form.get(0), form.get(1)))
        );

        for(int i=0; i<userList.size(); i++) {
            User user = userList.get(i);
            String nickname = user.nickname;
            if(nickname.length() < 2)
                continue;
            for(int j=0; j<nickname.length()-1; j++) {
                String subNickname = nickname.substring(j, j+2);
                checkDuplicatedNickname(subNickname, user);
                subNickNames.put(subNickname, user.email);
            }
        }
        return removeDuplicateAndSort(emails);
    }

    private static void checkDuplicatedNickname(String subNickname, User user) {
        if(subNickNames.containsKey(subNickname)) { // 닉네임 중복 가능성 O
            String email = subNickNames.get(subNickname);
            if(!email.equals(user.email)) {
                emails.add(email);
                emails.add(user.email);
            }
        }
    }

    private static List<String> removeDuplicateAndSort(List<String> emails) {
        List<String> result = emails.stream().distinct().collect(Collectors.toList());
        Collections.sort(result);
        return result;
    }
}
