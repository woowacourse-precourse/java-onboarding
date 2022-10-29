package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        int[] checkList = new int[forms.size()];
        List<String> result = new ArrayList<>();

        for (int i=0; i<forms.size(); i++) {

            int lt = -1;
            while (lt <= forms.get(i).get(1).length()-2) {
                lt++;
                int rt = lt + 1;
                while (rt < forms.get(i).get(1).length()) {
                for (int j=i+1; j<forms.size(); j++) {
                    String targetString = forms.get(i).get(1).substring(lt, rt+1);
                    if (forms.get(j).get(1).contains(targetString) && checkList[j] == 0) {
                        checkList[i] = 1;
                        checkList[j] = 1;
                        result.add(forms.get(i).get(0));
                        result.add(forms.get(j).get(0));

                        }
                    }
                    rt++;
                }
            }
        }
        List<String> distinctList = result.stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctList);
        return distinctList;
    }
}
