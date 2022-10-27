package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> resultSet = new TreeSet<>();
        Set<DuplicateSubNick> nickSubStrSet = new HashSet<>();

        for (List<String> strings : forms) {
            String email = strings.get(0);
            String nick = strings.get(1);

            for (int j = 0; j < nick.length() - 2; j++) {
                DuplicateSubNick tempVal = new DuplicateSubNick(email, nick.substring(j, j + 2));
                nickSubStrSet.add(tempVal);
            }
        }

        for (List<String> strings : forms) {
            String email = strings.get(0);
            String nick = strings.get(1);

            for (DuplicateSubNick tempVal : nickSubStrSet) {
                if (!email.equals(tempVal.getEmail()) && nick.contains(tempVal.getSubStrNick())) {
                    resultSet.add(email);
                }
            }
        }

        return List.copyOf(resultSet);
    }

    static class DuplicateSubNick {
        String email;
        String subStrNick;

        public DuplicateSubNick(String email, String subStrNick) {
            this.email = email;
            this.subStrNick = subStrNick;
        }

        public String getEmail() {
            return email;
        }

        public String getSubStrNick() {
            return subStrNick;
        }
    }
}
