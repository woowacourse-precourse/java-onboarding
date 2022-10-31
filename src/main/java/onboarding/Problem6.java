package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>(100);
        TreeSet<String> set = new TreeSet<>();

        for(int i = 0; i < forms.size(); ++i)
            for(int l = 0; l < forms.get(i).get(1).length() - 1; ++l){
                if(map.get(forms.get(i).get(1).substring(l, l + 2)) == null)
                    map.put(forms.get(i).get(1).substring(l, l + 2), forms.get(i).get(0));
                else{
                    set.add(forms.get(i).get(0));
                    set.add(map.get(forms.get(i).get(1).substring(l, l + 2)));
                }
            }

        return new ArrayList<>(set);
    }
}

