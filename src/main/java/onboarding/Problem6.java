package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        HashSet<String> ans = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String st = forms.get(i).get(1);
            for (int j = 0; j < st.length() - 1; j++) {
                String tmp = st.substring(j, j + 2);
                List<String> mail;
                if (hashMap.containsKey(tmp)) {
                    mail = hashMap.get(tmp);
                }

                else {
                    mail = new ArrayList<>();
                }
                mail.add(forms.get(i).get(0));
                hashMap.put(tmp, mail);
            }
        }

        for (String key : hashMap.keySet()) {
            List<String> mail = hashMap.get(key);
            if (mail.size() > 1) {
                for (int i = 0; i < mail.size(); i++) {
                    ans.add(mail.get(i));
                }
            }
        }

        List<String> answer = new ArrayList<>(ans);
        Collections.sort(answer);

        return answer;
    }
}
