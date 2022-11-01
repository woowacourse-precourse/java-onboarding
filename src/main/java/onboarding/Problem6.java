package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(forms.size() < 1 || forms.size() > 10000) {
            return null;
        }
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i<forms.size(); i++) {
            String str = forms.get(i).get(1);
            for (int j = 0; j<forms.size(); j++) {
                if(i == j) continue;
                List<String> jStringList = forms.get(j);
               
            }
        }
        List<String> resultList = emailList.stream().distinct().collect(Collectors.toList());
        resultList.sort(Comparator.naturalOrder());
        return resultList;
//        return answer;
    }
}
