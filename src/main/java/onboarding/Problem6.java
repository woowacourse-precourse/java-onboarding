package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++){
                String key = "";
                key += nickname.charAt(j);
                key += nickname.charAt(j+1);
                if (!map.containsKey(key)){
                    map.put(key, email);
                }
                else if (!map.get(key).equals(email)){
                    emailSet.add(email);
                    emailSet.add(map.get(key));
                }
            }
        }
        List<String> answer = new ArrayList<>(emailSet);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }



}
