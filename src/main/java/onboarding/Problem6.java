package onboarding;

import java.util.*;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NAME = 1;
    private static List<String> duplicate_Pattern_Check(List<String> pattern_list, List<List<String>> forms){
        List<String> email_list = new ArrayList<>();
        for(String pattern : pattern_list){
            int cnt = 0;
            List<String> tmp_email_list = new ArrayList<>();
            for(int i = 0 ; i< forms.size();i++){
                String name = forms.get(i).get(NAME);
                String email = forms.get(i).get(EMAIL);
                if(name.contains(pattern)){
                    tmp_email_list.add(email);
                }
                if(tmp_email_list.size()>1) {
                    Set<String> set = new LinkedHashSet<>(email_list);
                    set.addAll(tmp_email_list);
                    email_list = new ArrayList<>(set);
                }
            }
        }
        return email_list;
    }
    private static List<String> getPatternList(List<String> name_list) {
        List<String> pattern_list = new ArrayList<>();
        for(String name: name_list){
            for(int i = 0 ; i < name.length()-1; i ++){
                String pattern = name.substring(i,i+2);
                if(!pattern_list.contains(pattern)) pattern_list.add(pattern);
            }
        }
        return pattern_list;
    }
    private static List<String> getNameList(List<List<String>> forms){
        List<String> name_list = new ArrayList<>();
        for (List<String> crew : forms){
            name_list.add(crew.get(NAME));
        }
        return name_list;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> name_list = getNameList(forms);
        List<String> pattern_list = getPatternList(name_list);
        List<String> ans = duplicate_Pattern_Check(pattern_list,forms);
        Collections.sort(ans);
        return ans;
    }
}
