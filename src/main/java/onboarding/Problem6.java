package onboarding;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Problem6 {

    private static final Set<String> emails = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {

        for (List<String> form : forms) {

            String email = form.get(0);
            String name = form.get(1);
            int length = name.length();

            if (emails.contains(email) || length < 2) {
                continue;
            }

            for (int i = 0; i < length - 1; i++) {
                String s = name.substring(i, i + 2);
                for (List<String> user : forms) {
                    String userEmail = user.get(0);
                    String username = user.get(1);

                    if (Objects.equals(name, username) || !username.contains(s)) {
                        continue;
                    }

                    emails.add(userEmail);
                    emails.add(email);

                }
            }
        }

        return emails.stream()
                     .sorted()
                     .collect(toList());
    }
}
