package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashSet<String> emails = new HashSet<>();

        final Map<String, String > hashMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            final String name = forms.get(i).get(1);
            if(name.length() < 2){
                break;
            }
            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    final String email = hashMap.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(key, forms.get(i).get(0));
            }
        }

        final List<String> collect = emails.stream()
                .sorted()
                .collect(Collectors.toList());

        final String[] results = collect.toArray(new String[0]);

        return List.of(results);
    }
}
