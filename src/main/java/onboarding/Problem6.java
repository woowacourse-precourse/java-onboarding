package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        
        List<String> answer = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if (name.length() > 1) {
                for (int k = 0; k < name.length() - 1; k++) {
                    String newName = name.substring(k, k + 2);
                    Pattern pattern = Pattern.compile(".*" + newName + ".*");

                    for (int j = 0; j < forms.size(); j++) {
                        if (i != j) {
                            Matcher matcher = pattern.matcher(forms.get(j).get(1));
                            if (matcher.find()) {
                                answer.add(forms.get(j).get(0));
                                // break;
                            }
                        }
                    }
                }
            }
        }

        // List를 Set으로 변경
        Set<String> set = new HashSet<String>(answer);
        // Set을 List로 변경        
        List<String> newList = new ArrayList<String>(set);
        
        return newList;
    }
}
