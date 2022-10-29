package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                sb.setLength(0);
                sb.append(name.charAt(j)).append(name.charAt(j + 1));
                if (map.containsKey(sb.toString())) {
                    answer.add(email);
                    break;
                } else {
                    map.put(sb.toString(), 0);
                }
            }
        }
        return answer;
    }
}
