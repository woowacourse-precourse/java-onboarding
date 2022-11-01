package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> emails = new HashSet<>();

        final Map<String, String > crewList = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {

            final String name = forms.get(i).get(1);

            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j+2);
                if(crewList.containsKey(key)){
                    final String email = crewList.get(key);
                    if(!email.equals(forms.get(i).get(0))){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                crewList.put(key, forms.get(i).get(0));
            }
        }

        return answer;
    }
}
