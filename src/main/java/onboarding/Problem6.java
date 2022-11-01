package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NAME = 1;
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
        List<String> answer = List.of("answer");
        return answer;
    }
}
