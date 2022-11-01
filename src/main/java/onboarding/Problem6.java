package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for (List<String> person : forms) {
            int emailLength = person.get(0).length();
            String domain = person.get(0).substring(0, emailLength - 10);
            if (emailLength < 11 || emailLength >= 20) {
                break;
            }
            if (domain.equals("email.com")) {
                break;
            }

            String nickname = person.get(1);
            int nameLength = nickname.length();
            if (nameLength < 1 || nameLength >= 20) {
                break;
            }

            for (int i = 0; i < nameLength - 1; i++) {
                String key = nickname.substring(i, i + 2);
                if (map.containsKey(key)) {
                    emails.add(map.get(key));
                    emails.add(person.get(0));
                }
                map.put(key, person.get(0));
            }
        }
        ArrayList<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);
        return answer;
    }
}
