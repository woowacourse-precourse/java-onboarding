package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if(forms.size() < 1 || forms.size() > 10000) System.exit(1);
        // key-value 값으로 저장
        HashMap<String, String> map = new HashMap<>();
        // 객체 그 자체를 저장
        HashSet<String> emails = new HashSet<>();
        final int form_size = forms.size();
        for (int i = 0; i < form_size; i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            int name_size = name.length();
            if (name_size < 2 || name_size > 10000) {
                break;
            }
            int email_size = email.length();
            if (email_size < 11 || email_size >= 20) {
                break;
            }
            for (int j = 0; j < name_size - 1; j++) {
                String segment = name.substring(j, j + 2);
                if (map.containsKey(segment)) {
                    String find_email = map.get(segment);
                    if (!find_email.equals(email)) {
                        emails.add(find_email);
                        emails.add(email);
                    }
                }
                map.put(segment, email);
            }
        }
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());

        return answer;
    }
}
