package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> hashMap = new HashMap<>();
        HashSet<String> emails = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            final String nameSet = forms.get(i).get(1);
            for (int j = 0; j < nameSet.length() - 1; j++) {
                String same = nameSet.substring(j, j + 2);
                if (hashMap.containsKey(same)) {
                    String email = hashMap.get(same);
                    if (!emails.equals(forms.get(i).get(0))) {
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(same, forms.get(i).get(0));
            }
        }
        answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }
}
