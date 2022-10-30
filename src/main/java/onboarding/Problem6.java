package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> duplicateName(List<List<String>> forms){
        List<String> dupCheck = new ArrayList<>();
        List<String> dupList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(2);
            for (int j = 0; j < name.length(); j++) {
                String splitName = name.substring(j,j+1);
                if(dupCheck.contains(splitName) && !dupList.contains(splitName)){
                    dupList.add(splitName);
                } else if(!dupCheck.contains(splitName)) {
                    dupCheck.add(splitName);
                }
            }
        }
        return dupList;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
