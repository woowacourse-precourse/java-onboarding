package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < forms.size(); i++)
            for (int j = 0; j + 1 < forms.get(i).size(); j++)
                for (int k = i + 1; k < forms.size(); k++)
                    if (forms.get(k).get(1).contains(forms.get(i).get(1).substring(j, j + 2)))
                    {
                        list.add(forms.get(i).get(0));
                        list.add(forms.get(k).get(0));
                    }
        HashSet<String> hashSet = new HashSet<>(list);
        List<String> ret = new ArrayList<String>(hashSet);
        ret.sort(Comparator.naturalOrder());
        return ret;
    }
}
