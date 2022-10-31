package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    static HashSet<String> set = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        for(int i=0; i<forms.size(); i++){
            for(int j=i; j<forms.size(); j++){
                if(i == j) continue;
                compareName(forms.get(i), forms.get(j));
            }
        }

        List<String> answer = set.stream().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }

    private static void compareName(List<String> strings, List<String> strings1) {
        String name1 = strings.get(1);
        String name2 = strings1.get(1);
        for(int i=0; i<name1.length()-1; i++){
            for (int j = 0; j < name2.length()-1; j++) {

                if(name1.charAt(i) == name2.charAt(j) && name1.charAt(i+1) == name2.charAt(j+1)){
                    set.add(strings.get(0));
                    set.add(strings1.get(0));
                    return;
                }
            }
        }
    }

}
