package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        HashMap<String, String> map = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            for (int j = 0; j < name.length() - 1; j++) {
                String dupWord = name.substring(j, j + 2);
                if (map.containsKey(dupWord)) {
                    String findEmail = map.get(dupWord);
                    if (!findEmail.equals(email)) {
                        emails.add(findEmail);
                        emails.add(email);
                    }
                }
                map.put(dupWord, email);
            }
        }
        answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }

}
