package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(findDup(forms));
        return answer;
    }

    public static TreeSet<String> findDup(List<List<String>> forms) {
        TreeSet<String> result = new TreeSet<>();
        String dn = forms.get(0).get(1).substring(0, 2);
        for(int j = 0;j<forms.size();j++){
            int i=1;
            while(i<forms.get(j).get(1).length()-1){
                for (int k=j;k<forms.size();k++){
                    if (forms.get(k).get(1).contains(dn)){
                        result.add(forms.get(j).get(0));
                        result.add(forms.get(k).get(0));
                    }
                }
                dn = forms.get(j).get(1).substring(i, i+2);
                i++;
            }
        }
        return result;
    }
}
