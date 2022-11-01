package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        Map<String, String> duplicateCheckMap = new HashMap<String, String>();
        List<String> tmpList = new ArrayList<String>();

        for (int i=0; i<forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j=0; j<nickname.length()-1; j++) {
                if (duplicateCheckMap.containsKey(nickname.substring(j, j+2))) {
                    answer.add(email);
                    answer.add(duplicateCheckMap.get(nickname.substring(j, j+2)));
                }
                else {
                    duplicateCheckMap.put(nickname.substring(j, j+2), email);
                }
            }
        }

        for (String item : answer) {
            if (!tmpList.contains(item))
                tmpList.add(item);
        }
        answer = tmpList;
        Collections.sort(answer);

        return answer;
    }
}
