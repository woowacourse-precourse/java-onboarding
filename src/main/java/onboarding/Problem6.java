package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> crew = new ArrayList<>();
        for (int i = 0; i < forms.size() - 1; i++){
            String str = forms.get(i).get(1);
            for (int j = 0; j < str.length() - 1; j++){
                String sub_str = str.substring(j, j+2);
                for (int k = i + 1; k < forms.size(); k++){
                    if (forms.get(j).get(1).contains(sub_str))
                        crew.add(forms.get(i).get(0));
                    crew.add(forms.get(j).get(0));
                }
            }
        }
        crew = sortEmail(crew);
        return crew;
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