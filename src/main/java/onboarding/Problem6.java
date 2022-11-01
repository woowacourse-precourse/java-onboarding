package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();
        for(int i = 0; i < forms.size(); i++)
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++){
                if(map.get(forms.get(i).get(1).substring(j, j + 2)) == null)
                    map.put(forms.get(i).get(1).substring(j, j + 2), forms.get(i).get(0));
                else{
                    set.add(forms.get(i).get(0));
                    set.add(map.get(forms.get(i).get(1).substring(j, j + 2)));
                }
            }
        return new ArrayList<>(set);
    }
}
