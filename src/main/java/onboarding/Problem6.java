package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        String doubleCheck ="";
        for (int i = 0; i < forms.size(); i++) {
            String c = forms.get(i).get(1); //닉네임

            for (int j = 0; j < c.length()-1; j++) {
                doubleCheck = c.substring(j, j + 2); //두글자씩 자르기

                //자기자신이 아니고, 다른 곳에 포함되어 있다면 answer에 담기
                for (int k = 0; k < forms.size(); k++) {
                    if (forms.get(k).get(1).contains(doubleCheck) && forms.get(k).get(1) != c) {
                        map.put(forms.get(k).get(0), 0);
                    }
                }
            }

        }
        List<String> answer = new ArrayList<>(map.keySet());
        Collections.sort(answer);

        return answer;
    }
}
