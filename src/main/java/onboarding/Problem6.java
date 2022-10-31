package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String,String> maps = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        fillToMap(forms);
        return answer;
    }
    static void fillToMap(List<List<String>> forms){
        for(List<String> data : forms) {fillToSet(data.get(1));}
    }

}
