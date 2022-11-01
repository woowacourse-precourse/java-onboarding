package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length()-1; i++) {
                String target = nickname.substring(i, i+2);
                if (map.get(target) == null)  map.put(target, new ArrayList<>());
                map.get(target).add(email);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                for (int i = 0; i < map.get(key).size(); i++) answer.add(map.get(key).get(i));
            }
        }
        Collections.sort(answer);

        return answer;


    }
    static List<Integer> repeat(List<List<String>> forms, List<String> crew, int num) {
        List<Integer> plus = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).equals(crew.get(1))) {
                continue;
            }
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                if (crew.get(1).substring(num, num + 2).equals(forms.get(i).get(1).substring(j, j+2))) {
                    plus.add(i);
                    break;
                }
            }
        }
        return plus;
    }


}
