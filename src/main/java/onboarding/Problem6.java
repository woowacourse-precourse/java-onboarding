package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        final List<Crew> crews = forms.stream()
                .map(Crew::of)
                .collect(Collectors.toList());

        final Map<String, List<Crew>> crewMap = new HashMap<>();

        return new ArrayList<String>();
    }

    public static class Crew {

        private final String email;
        private final String nickname;

        private Crew(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public static Crew of(List<String> form) {
            return new Crew(form.get(0), form.get(1));
        }

        public String getEmail() {
            return email;
        }

        public String getNickname() {
            return nickname;
        }
    }

}
