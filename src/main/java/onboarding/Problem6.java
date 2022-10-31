package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        final Map<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < forms.get(1).size(); i++) {
            final String name = forms.get(1).get(i).toString();

            if (name.length() < 2) {
                break;
            }


            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j + 2);
                if (hashMap.containsKey(key)) {
                    final String email = hashMap.get(key);
                    if (!email.equals(forms.get(0).get(i))) {
                        emails.add(email);
                        emails.add(forms.get(0).get(i));
                    }
                }
                hashMap.put(key, forms.get(0).get(i));
            }
        }
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }
}