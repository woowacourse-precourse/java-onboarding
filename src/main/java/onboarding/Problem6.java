package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int p = i + 1; p < forms.size(); p++) {
                for (int s = 0; s < forms.get(i).get(1).length(); s++) {
                    for (int j = 0; j < forms.get(p).get(1).length(); j++) {
                        if (forms.get(i).get(1).charAt(s) == forms.get(p).get(1).charAt(j)) {
                            if (s + 1 < forms.get(i).get(1).length() && j + 1 < forms.get(p).get(1).length() && forms.get(i).get(1).charAt(s + 1) == forms.get(p).get(1).charAt(j + 1)) {
                                hash.add(forms.get(i).get(0));
                                hash.add(forms.get(p).get(0));
                                break;
                            }
                        }
                    }
                }
            }

        }
        Iterator<String> iter = hash.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            answer.add(str);
        }
        Collections.sort(answer);
        return answer;
    }
}
