package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static Map<String, List<String>> list_to_map(List<List<String>> forms){

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if(map.containsKey(nickname)) {
                map.get(nickname).add(email);
            }
            else {
                List<String> email_list = new ArrayList<>();
                email_list.add(email);
                map.put(nickname, email_list);
            }
        }

        return map;
    }

}
