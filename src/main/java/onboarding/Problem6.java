package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> list = new ArrayList<>(List.of());
        List<HashSet<String>> line = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++){
            HashSet<String> map = new HashSet<>();
            line.add(map);
        }
        for (int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            for (int j = 0; j < forms.size(); j++) {
                if (j != i) {
                    HashSet<String> t = line.get(j);
                    for (int k = 0; k < name.length() - 1; k++) {
                        t.add(name.substring(k, k + 2));
                    }
                    line.set(j, t);
                }
            }
        }
        for (int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++){
                if (line.get(i).contains(name.substring(j, j+2))){
                    list.add(forms.get(i).get(0));
                }
            }
        }
        HashSet<String> newline = new HashSet<>(list);
        List<String> answer = new ArrayList<>(newline);
        Collections.sort(answer);
        return answer;
    }
}
