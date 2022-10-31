package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < forms.size(); i++) { // forms[i][1].substring(j,j+2)를 전체랑 비교.
            for (int j = 0; j < forms.size(); j++) {
                for (int k = 0; k < forms.get(i).get(1).length() - 1; k++) {
                    for (int l = 0; l < forms.get(j).get(1).length() - 1; l++) {
                        if (i != j) {

                            boolean a = forms.get(i).get(1).substring(k, k + 2).charAt(0) == forms.get(j).get(1).substring(l, l + 2)
                                    .charAt(0);
                            boolean b = forms.get(i).get(1).substring(k, k + 2).charAt(1) == forms.get(j).get(1).substring(l, l + 2)
                                    .charAt(1);
                            if (a && b) {
                                map.put(forms.get(i).get(1), forms.get(i).get(0));
                                map.put(forms.get(j).get(1), forms.get(j).get(0));
                                set.add(forms.get(i).get(1));
                                set.add(forms.get(j).get(1));
                            }
                        }
                    }
                }
            }
        }

        Iterator itr = set.iterator();
        while(itr.hasNext()) {
            answer.add(map.get((String) itr.next()));
        }

        Collections.sort(answer);

        return answer;
    }
}
