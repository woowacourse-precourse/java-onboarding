package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<String, String>();
        // 두글자닉네임, 이메일
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nick = forms.get(i).get(1);
            for (int j = 0; j < nick.length() - 1; j++) {
                if (map.containsKey(nick.substring(j, j + 2))) {
                    answer.add(email);
                    answer.add(map.get(nick.substring(j, j + 2)));
                } else {
                    map.put(nick.substring(j, j + 2), email);
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);
        answer = new ArrayList<String>(set);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
