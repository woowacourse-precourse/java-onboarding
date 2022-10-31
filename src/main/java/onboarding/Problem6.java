package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        User[] crew = inItUsers(forms);

        return answer;
    }
    private static User[] inItUsers(List<List<String>> forms) {

        int size = forms.size();
        int emailIndex = 0;
        int nickIndex = 1;

        User[] crew = new User[size];
        for (int i = 0; i < size; i++) {
            List<String> user = forms.get(i);

            String email = user.get(emailIndex);
            String nick = user.get(nickIndex);

            crew[i] = new User(email, nick);
        }

        return crew;
    }
    private static class User {
        String email;
        String nick;

        private User(String email, String nick) {
            this.email = email;
            this.nick = nick;
        }

        private String getEmail() {
            return email;
        }

        private String getNick() {
            return nick;
        }
    }

}
