package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> email = new HashSet<>();
        List<List<String>> splitName = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            splitName.add(new ArrayList<>());
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String temp = "";
                temp += forms.get(i).get(1).charAt(j);
                temp += forms.get(i).get(1).charAt(j + 1);
                splitName.get(i).add(temp);
            }
        }
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                Set<String> set = new HashSet<>();
                for (int k = 0; k < splitName.get(i).size(); k++) {
                    set.add(splitName.get(i).get(k));
                }
                for (int k = 0; k < splitName.get(j).size(); k++) {
                    set.add(splitName.get(j).get(k));
                }
                if(set.size() != splitName.get(i).size() + splitName.get(j).size()){
                    email.add(forms.get(i).get(0));
                    email.add(forms.get(j).get(0));
                }
            }
        }
        List<String> answer = new ArrayList<>(email)
                                    .stream().sorted().collect(Collectors.toList());
        return answer;
    }
}
