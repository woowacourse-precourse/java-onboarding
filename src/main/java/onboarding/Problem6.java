package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < forms.size() - 1; i++){
            String str = forms.get(i).get(1);
            for (int j = 0; j < str.length() - 1; j++){
                String sub_str = str.substring(i, i+2);
                for (int k = i + 1; k < forms.size(); k++){
                    if (forms.get(j).get(1).contains(sub_str))
                        ret.add(str);
                        ret.add(forms.get(j).get(0));
                }
            }
        }
        return ret;
    }

    private static List<String> sortEmail(List<String> str){
        List<String> list = new ArrayList<String>();
        for(int i=0; i< str.size(); i++)
            if(!list.contains(str.get(i)))
                list.add(str.get(i));
        Collections.sort(list);
        return list;
    }

}
