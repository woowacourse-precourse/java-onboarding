package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i<forms.size(); i++) {
            List<String> data = forms.get(i);
            names.add(data.get(1));
        }

        ArrayList<Integer> indx = new ArrayList<>();

        for (int i = 0; i < names.size()-1; i++) {
            for (int j = i+1; j < names.size(); j++) {
                String a = names.get(i);
                String b = names.get(j);

                for (int k = 0; k <= a.length()-2; k++) {
                    if (b.contains(a.substring(k,k+2))){
                        indx.add(i);
                        indx.add(j);
                        break;
                    }
                }
            }
        }

        List<Integer> newList = indx.stream().distinct().collect(Collectors.toList());
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i<newList.size(); i++) {
            answer.add(forms.get(newList.get(i)).get(0));
        }
        Collections.sort(answer);

        return answer;
    }
}
